package test.AWT.part1;

import java.awt.*;

public class BorderLayout_test {
    public static void main(String[] args) {
        Frame f=new Frame("borderlayout_tset");

        //给f设置layout布局
        f.setLayout(new BorderLayout(30,20));
        //垂直间距和水平间距
        f.setVisible(true);
        //f.setBounds(100,100,500,300);

        f.add(new Button("North"),BorderLayout.NORTH);
        f.add(new Button("Center"),BorderLayout.CENTER);
        f.add(new Button("South"),BorderLayout.SOUTH);
        f.add(new Button("Wesh"),BorderLayout.WEST);
        f.add(new Button("East"),BorderLayout.EAST);
        //为四个区域各添加一个按钮

        f.pack();
        //如果没有第13行，依靠这个pack方法依旧可以成功创建图形窗口
    }
}
//Border将图形窗口非为几个区块
//测试代码成功将各个区块加上对应的按钮
