package test.AWT.part4.process_bitmap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class test {
    final int AREA_WIDTH = 500;
    final int AREA_HEIGHT = 400;
    //设置位图的大小

    int prex = -1;
    int prey = -1;
    //设置鼠标前一个x，y
    //因为绘制线段需要两个坐标，一个前x，y，，，一个当前的x，y
    //e.getX(),,e.getY();

    PopupMenu colorMenu = new PopupMenu();
    MenuItem redItem = new MenuItem("RED");
    MenuItem greenItem = new MenuItem("GREEN");
    MenuItem blueItem = new MenuItem("BLUE");

    //定义一个BufferedImage对象
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    //宽度，高度，以及类型：每个像素点采用4个字节存储
    //就是创建一张缓冲图片
    Graphics g = image.getGraphics();
    //通过对象image 获取专属画笔 image.getGraphics();
    //创建画板以及画笔

    Frame f = new Frame("draw_test");
    //创建窗口容器

    Canvas drawArea = new Canvas() {
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
            //以image为绘制背景
        }
    };
    //将缓冲图片image绘制到0 0 坐标点
    //Graphics gg=drawArea.getGraphics();
    //也可以给画布来个专属画笔
    Color forceColor = Color.BLACK;

    public void init() {
        //为三个按钮定义监视器
        ActionListener menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                //获取点击按钮上的String
                switch (command) {
                    case "RED":
                        forceColor = Color.RED;
                        break;
                    case "GREEN":
                        forceColor = Color.GREEN;
                        break;
                    case "BLUE":
                        forceColor = Color.BLUE ;
                        break;
                }
            }
        };
        //定义组件监视器
        //点击到哪个按键就将Color设置为哪种颜色
        redItem.addActionListener(menuListener);
        greenItem.addActionListener(menuListener);
        blueItem.addActionListener(menuListener);

        //下列将三个子菜单添加到主菜单中
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        //下列将主菜单添加到绘图区块中
        drawArea.add(colorMenu);

        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
        //g为image的专属画笔
        //将iamge的图片背景设置为白色，默认应该就是白色

        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));

        //下列为绘图区块添加鼠标监控器
        //drawArea.addMouseListener(new MouseAdapter() { //这里注册监控器出现错误：事件和移动事件还是有点略微差异
        drawArea.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (prex > 0 && prey > 0) {
                    g.setColor(forceColor);
                    g.drawLine(prex, prey, e.getX(), e.getY());
                }
                prex = e.getX();
                prey = e.getY();
                drawArea.repaint();
            }
        });
        //获取鼠标坐标，重新绘制drawArea


        //下列监视右键弹出菜单
        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                boolean flag = e.isPopupTrigger();
                if (flag) {
                    colorMenu.show(drawArea, e.getX(), e.getY());
                }
                prex = -1;
                prey = -1;
                //鼠标松开时将两个变量重置：防止绘图出现错误
            }
        });

        f.add(drawArea);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new test().init();
    }
}
//很神奇：代码的实现非常值得重点探究以及考察
