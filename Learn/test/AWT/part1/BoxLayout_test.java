package test.AWT.part1;

import javax.swing.*;
import java.awt.*;

public class BoxLayout_test {
    public static void main(String[] args) {
        Frame f=new Frame("boxLayout_test");

        BoxLayout b=new BoxLayout(f,BoxLayout.Y_AXIS);
        //垂直排列
        f.setLayout(b);

        f.add(new Button("button1"));
        f.add(new Button("button2"));

        f.pack();
        f.setVisible(true);
    }
}
//Y为垂直排列
//成功垂直展示两个按钮
