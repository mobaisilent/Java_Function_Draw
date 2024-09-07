package test.AWT.part1;

import java.awt.*;

public class GridLayout_test {
    public static void main(String[] args) {
        Frame f=new Frame("count_machine");
        f.setBounds(100,100,500,300);
        f.setVisible(true);
        Panel p=new Panel();
        p.add(new TextField(30));
        //参数30表示这个文本框占30列个单位

        f.add(p,BorderLayout.NORTH);
        //Frame默认即为BorderLayout
        Panel p2=new Panel();
        p2.setLayout(new GridLayout(3,5,4,4));
        //3行5列 水平间距为4 垂直间距为4
        //将p2这个容器进行Grid网格布局

        for(int i=0;i<10;i++){
            p2.add(new Button(i+""));
        }
        p2.add(new Button("+"));
        p2.add(new Button("-"));
        p2.add(new Button("*"));
        p2.add(new Button("/"));
        p2.add(new Button("="));

        f.add(p2);
        f.pack();
        //pack自动调整布局
    }
}
//成功完成计算器图形框架
