package test.AWT.part2.Dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog_test2 {
    public static void main(String[] args) {
        Frame f = new Frame("Dialog_test");

        Dialog d1 = new Dialog(f, "model_dialog", true);

        Button b1 = new Button("open model_dialog");

        d1.setBounds(20, 30, 300, 400);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });

        //向对话框中添加内容
        Box b = Box.createVerticalBox();
        b.add(new TextArea(20, 30));
        b.add(new Button("YES?"));
        d1.add(b);


        f.add(b1);
        f.pack();
        f.setVisible(true);
    }
}
//向对话框中添加内容
//成功向一个对话框中添加一个文本域和一个按钮