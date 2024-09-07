package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FunctionDraw {

    public static final int MYWIDTH = 1000;
    public static final int MYHEIGHT = 800;
    public static final int MAXSIZE = 5000;
    //取最长直径为5000用来满足缩放需求

    private String function;
    //用来保存函数解析式
    public double myScale = 1;
    //缩放比例
    boolean canDraw = false;
    //能否绘制函数参数，clear按键需要使用

    JFrame jf = new JFrame("Function_Draw");
    //主窗口

    TextField tips = new TextField("请输入函数表达式：");
    TextField functionField = new TextField();
    TextField showScale = new TextField();
    //提示文本域，函数输入文本域，缩放比例系数显示文本域

    Button okButton = new Button("OK");
    //开始绘制按键

    JButton biggerButton = new JButton("Enlarger");
    JButton smallerButton = new JButton("Reduce");
    JButton claerButton = new JButton("Clear");
    //放大，缩小，清空按钮

    MyCanvas mc = new MyCanvas();
    //自定义画布对象

    FunctionSolution fs = new FunctionSolution();
    //函数处理类对象

    ShowDialog sd = new ShowDialog();
    //对话框处理类对象


    //对象初始化及处理方法
    public void init() {

        tips.setColumns(12);
        tips.setForeground(Color.RED);
        tips.setEditable(false);
        //提示文本域列数，字体颜色，不可编辑

        functionField.setColumns(20);
        showScale.setColumns(13);
        //函数输入域的列数，和缩放比例显示信息列数

        JPanel jPanel1 = new JPanel();
        jPanel1.add(tips);
        jPanel1.add(functionField);
        okButton.setBackground(Color.GREEN);
        functionField.setForeground(Color.RED);
        jPanel1.add(okButton);
        jf.setLayout(new BorderLayout());
        jf.add(jPanel1, BorderLayout.NORTH);
        //tips，functionField和okButton添加到jPanel1中

        JPanel jPanel2 = new JPanel();
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(mc, BorderLayout.CENTER);
        jf.add(jPanel2, BorderLayout.CENTER);
        //将画布mc添加到jPanel2中，再将jPanel设置为中部区域

        biggerButton.setBackground(Color.PINK);
        smallerButton.setBackground(Color.PINK);
        claerButton.setBackground(Color.PINK);
        //设置背景颜色
        biggerButton.setActionCommand("Enlarger");
        smallerButton.setActionCommand("Reduce");
        claerButton.setActionCommand("Clear");
        //设置ActionCommand，方便方法调用是getActionCommand

        addButtonListener(biggerButton);
        addButtonListener(smallerButton);
        addButtonListener(claerButton);
        // 添加按钮监听器

        JPanel jPanel3 = new JPanel();
        jPanel3.setBorder(BorderFactory.createLineBorder(Color.PINK));
        //设置边框颜色
        jPanel3.setLayout(new FlowLayout());
        //设置布局管理器：顺序水平放置
        jPanel3.add(biggerButton);
        jPanel3.add(smallerButton);
        jPanel3.add(claerButton);
        //添加三个按钮

        JLabel label = new JLabel(" scale:");
        jPanel3.add(label);
        jPanel3.add(showScale);
        jPanel1.add(jPanel3);
        //显示”scale“的一个简单便签

        jf.setSize(MYWIDTH, MYHEIGHT);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        //设置主窗口的大小，可见，默认关闭方式，位于windows窗口中间

        functionField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (functionField.getText().isEmpty()) {
                        sd.showEmptyWarningDialog(jf);
                    } else {
                        function = fs.getFunction(functionField.getText());
                        //将y=截取掉
                        if (!new FunctionSolution().checkFunction(function)) {
                            canDraw = false;
                            //弹出提示对话框
                            sd.showEnterWarningDialog(jf);
                            functionField.setText("");
                            //输入了错误函数表达式之后自动将文本框清空
                        } else {
                            System.out.println("You drawed the function:" + function);
                            //打印显示信息
                            canDraw = true;
                        }
                        mc.repaint();
                    }
                }
            }
        });
        //为函数输入文本域点击回车事件监控器C

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (functionField.getText().isEmpty()) {
                    sd.showEmptyWarningDialog(jf);
                } else {
                    function = fs.getFunction(functionField.getText());
                    //将y=截取掉
                    if (!new FunctionSolution().checkFunction(function)) {
                        canDraw = false;
                        //弹出提示对话框
                        sd.showEnterWarningDialog(jf);
                        functionField.setText("");
                        //输入了错误函数表达式之后自动将文本框清空
                    } else {
                        System.out.println("You drawed the function:" + function);
                        //打印显示信息
                        canDraw = true;
                    }
                    mc.repaint();
                }
            }
        });
        //为ok按键田间事件监控器

        jf.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    if (myScale > 5.0 || myScale < 0.25) {
                        myScale = 1;
                        sd.showScaleMessageDialog(jf);
                    } else myScale *= 1.1;
                } else {
                    if (myScale > 5.0 || myScale < 0.25) {
                        myScale = 1;
                        sd.showScaleMessageDialog(jf);
                    } else
                        myScale /= 1.1;
                }
                mc.repaint();
            }
        });
        //为主窗口jf添加鼠标滚轮监控器，处理放大缩小事务
    }

    //有太多公共变量：Canvas不方便移动到外面去
    class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            showScale.setText(Double.toString(myScale));

            //获取画笔
            Graphics2D g2 = (Graphics2D) g;
            g2.translate(MYWIDTH / 2, MYHEIGHT / 2 - 30); //主要是考虑到上面有个panel模块

            g2.setColor(Color.LIGHT_GRAY);
            for (int i = -MAXSIZE; i <= MAXSIZE; i += 20) {
                g2.drawLine(i, -MAXSIZE / 2, i, MAXSIZE / 2);  //-25到25左右
            }
            for (int i = -MAXSIZE / 2; i <= MAXSIZE / 2; i += 20) {
                g2.drawLine(-MAXSIZE / 2, i, MAXSIZE / 2, i);  //-19到19左右
            }
            //绘制小方格，不需要改动

            g2.scale(myScale, myScale);
            //设置缩放

            //绘制x轴和y轴
            g2.setColor(Color.BLACK);
            g2.drawLine(-MAXSIZE / 2, 0, MAXSIZE / 2, 0);
            g2.drawLine(0, -MAXSIZE / 2, 0, MAXSIZE / 2);

            //绘制刻度
            for (int i = -MAXSIZE / 2; i <= MAXSIZE / 2; i += 20) {
                g2.drawLine(i, -5, i, 5);
                g2.drawString(Integer.toString(i / 20), i, -10);
                //每20个像素点为1个刻度单位
            }
            for (int i = -MAXSIZE / 2; i <= MAXSIZE / 2; i += 20) {
                g2.drawLine(-5, i, 5, i);
                g2.drawString(Integer.toString(-i / 20), 10, i);
            }

            //绘制原点
            g2.setColor(Color.RED);
            g2.fillArc(-4, -4, 8, 8, 0, 360);
            //用宽8长8的实心小圆点覆盖0 0 坐标实现原点的绘制

            if (canDraw) {
                g2.setColor(Color.RED);
                for (int x = -MAXSIZE*2; x <= MAXSIZE*2; x++) {
                    double y = fs.calculateFunction(function, (double) x / 100);  //该函数这里传入的是一个double的值
                    if (y >= -MAXSIZE / 2 && y <= MAXSIZE / 2) {
                        //System.out.println("here x/5="+x/5+"  y*20="+y*20);
                        g2.fillOval(x / 5, -(int) (y * 100) / 5, 2, 2);
                        //区分x,y的实际值和图像的值
                        //y的计算处/100之后又*20相当于x/5，保持了一样的缩放比例
                        //每拖动一次计算一次造成计算冗余
                    }
                }
            }
            //canDraw参数为true是绘制函数，处理函数的缩放，实现于坐标轴相对应
        }
    }
    //自定义的画布类，实现对画布对象mc的绘制功能

    public void addButtonListener(JButton b) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Enlarger")) {
                    if (myScale > 5.0 || myScale < 0.25) {
                        myScale = 1;
                        sd.showScaleMessageDialog(jf);
                    } else
                        myScale *= 1.1;
                } else if (e.getActionCommand().equals("Reduce")) {
                    if (myScale > 5.0 || myScale < 0.25) {
                        myScale = 1;
                        sd.showScaleMessageDialog(jf);
                    } else
                        myScale /= 1.1;
                } else if (e.getActionCommand().equals("Clear")) {
                    myScale = 1;
                    functionField.setText("");
                    canDraw = false;
                }
                mc.repaint();
            }
        });
        //自定义方法，为放大，缩小清空按钮添加监控事件，用一个方法去处理，减少代码冗余
    }

    public static void main(String[] args) {
        new FunctionDraw().init();
    }
    //main方法
}
