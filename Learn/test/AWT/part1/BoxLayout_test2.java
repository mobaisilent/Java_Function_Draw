package test.AWT.part1;

import javax.swing.*;
import java.awt.*;

public class BoxLayout_test2 {
    public static void main(String[] args) {
        Frame f=new Frame();

        Box hbox=Box.createHorizontalBox();
        //水平Box
        hbox.add(new Button("hbox1"));
        hbox.add(new Button("hbox2"));

        Box vbox=Box.createVerticalBox();
        //纵向Box
        vbox.add(new Button("vbox1"));
        vbox.add(new Button("vbox2"));

        f.add(hbox,BorderLayout.NORTH);
        //将水平Box放入到NORTH中

        f.add(vbox);

        f.pack();
        //设置f的最佳大小
        f.setVisible(true);
    }
}
//演示展示成功
