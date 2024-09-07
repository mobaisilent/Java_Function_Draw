package test.AWT.part4.draw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class test1 {
    final String RECT_SHAPE = "rect";
    final String OVAL_SHAPE = "oval";

    Frame f = new Frame("test_draw");

    Button b1 = new Button("draw_rect");
    Button b2 = new Button("draw_oval");

    String shape = "";

    Mycanvas mc=new Mycanvas();
    //用自己定义的一个类：继承了Canvas类（画布类）

    //下面回绘图方法
    public void init(){
        mc.setPreferredSize(new Dimension(300,200));
        //设置首选大小

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape=RECT_SHAPE;
                mc.repaint();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape=OVAL_SHAPE;
                mc.repaint();
            }
        });
        //每次点击这两个按钮都会repaint一次

        Panel p=new Panel();
        p.add(b1);
        p.add(b2);

        f.add(mc);
        f.add(p,BorderLayout.SOUTH);


        f.pack();
        f.setVisible(true);
    }
    //init方法为图形初始化


    //下面内部类为绘图内部类
    private class Mycanvas extends Canvas {
        @Override
        public  void paint(Graphics g){
            Random r=new Random();

            if(shape.equals((RECT_SHAPE))){
                //绘制矩形
                g.setColor(Color.BLACK);
                g.drawRect(r.nextInt(200),r.nextInt(100),60,40);
            }
            else if(shape.equals(OVAL_SHAPE)){
                //绘制椭圆形
                g.setColor(Color.RED);
                g.drawOval(r.nextInt(200),r.nextInt(100),60,40);
            }
        }

    }
    //repaint 就像是调用了paint 顾名思义就是重新paint

    ;

    public static void main(String[] args) {
        new test1().init();
    }
}

//Canvas类充当画布
//自定义类，继承Canvas类，重写paint(Graphics g)方法完成画图
