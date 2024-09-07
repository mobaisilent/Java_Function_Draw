package test.AWT.part2.Dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog_test1 {
    public static void main(String[] args) {
        Frame f = new Frame("Dialog_test");

        Dialog d1 = new Dialog(f, "model_dialog", true);
        Dialog d2 = new Dialog(f, "dismodel_dialog", true);

        Button b1 = new Button("open model_dialog");
        Button b2 = new Button("open dismodel_dialog");

        d1.setBounds(20, 30, 300, 400);
        d2.setBounds(20, 30, 300, 400);
        //设置两个对话框的位置及大小

        //下列给b1和b2绑定监听事件，也就是点击到b1和b2的时候执行一段代码
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
            }
        });

        f.add(b1, BorderLayout.NORTH);
        f.add(b2);
        f.pack();
        f.setVisible(true);
    }
}
//两个按钮创建成功以及两个对话框的弹出成功