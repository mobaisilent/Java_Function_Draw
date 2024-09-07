package test.SWING.Part1.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class type5 {

    JFrame jf = new JFrame("option_message_dialog_test");

    JTextArea jta = new JTextArea(6, 30);
    //创建文本域空间

    JButton btn = new JButton(new AbstractAction("pop chooser dialog") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showOptionDialog(jf, "please choose type", "choose_dialog", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"big", "middle", "small"}, "middle");
            //创建选择对话框，有点像是之前的那个的 下拉菜单条对话框
            switch (result) {
                case 0:
                    jta.setText("user opt the big");
                    break;
                case 1:
                    jta.setText("user opt the middle");
                    break;
                case 2:
                    jta.setText("user opt the small");
                    break;
            }
        }
    });

    public void init() {
        jf.add(jta);
        jf.add(btn, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new type5().init();
    }
}
//ok 成功创建处选择对话框，将选择内容打印在文本框中
