package test.AWT.part1;

import javax.swing.*;
import java.awt.*;

public class BoxLayout_test3 {
    public static void main(String[] args) {
        Frame f=new Frame();

        Box hbox=Box.createHorizontalBox();
        hbox.add(new Button("hbox_button1"));
        hbox.add(Box.createHorizontalGlue());
        //创建一个可以左右/上下拉伸的间距
        hbox.add(new Button("hbox_button2"));
        hbox.add(Box.createHorizontalStrut(10));
        //固定间距，不可拉伸
        hbox.add(new Button("hbox_button3"));
        //结果是2号按键和3号按键的距离始终不变


        //下列为测试纵向间距
        Box vbox=Box.createVerticalBox();
        vbox.add(new Button("vbox_button1"));
        vbox.add(Box.createVerticalGlue());
        //创建一条可拉伸的间距
        vbox.add(new Button("vbox_button2"));
        vbox.add(Box.createVerticalStrut(10));
        //创建间距为10的不可拉伸的间距
        vbox.add(new Button("vbox_button3"));


        f.add(hbox,BorderLayout.NORTH);
        //f.add(hbox);
        f.add(vbox);
        //默认是放入CENTER区块中
        //如果是第33行的话 34行会将第33行的内容给替换掉

        f.setVisible(true);
        f.pack();
    }
}
//为Box添加间距
//创建成功，部件及其间隔
