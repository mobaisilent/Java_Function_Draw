package test.SWING.Part1.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class type4 {
    JFrame jf = new JFrame("chooser_dialog");

    JTextArea jta = new JTextArea(6, 30);

    JButton jb = new JButton(new AbstractAction("input chose message dialog") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object result = JOptionPane.showInputDialog(jf, "choose", "choose input dialog", JOptionPane.DEFAULT_OPTION, null, new String[]{"user1", "user2", "user3"}, "user1");
            //承载对象：提示消息：窗口标题，消息类型：图标，下拉选项，默认选项
            if (result != null) {
                jta.append("\n" + result.toString());
            }
        }
    });

    public void init() {
        jta.append("hello");
        jf.add(jta);
        jf.add(jb, BorderLayout.SOUTH);

        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new type4().init();
    }
}
//关于弹出式选择对话框
/*
* 窗口对象：用于表示输入对话框将显示在哪个窗口中。
提示：输入对话框要显示的文本。
标题：输入对话框的标题。
消息类型：输入对话框的类型。
初始输入：初始文本将显示在输入字段中。
下拉列表的选项：下拉列表中的选项。
默认选项：下拉列表中的默认选项。
* */
