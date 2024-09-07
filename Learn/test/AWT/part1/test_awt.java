package test.AWT.part1;

import java.awt.*;

public class test_awt {
    public static void main(String[] args) {
        //设置窗口部件
        Frame f=new Frame("这里是测试窗口");


        //设置窗口的位置大小
        f.setLocation(100,100);
        f.setSize(500,300);

        //设置窗口的可见性
        f.setVisible(true);
    }
}
//窗口创建成功，但是无法关闭，也就是未设置关闭条件判断
