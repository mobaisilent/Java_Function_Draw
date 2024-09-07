package test.SWING.Part1.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class type1 {

    JFrame jf = new JFrame("test_message_dialog");
    //测试弹出式消息对话框

    JTextArea jta = new JTextArea(6, 30);
    //6行30列的文本域空间

    JButton btn = new JButton(new AbstractAction("ERROR_MESSAGE_BUTTON") {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(jf, jta.getText(), "message_dialog", JOptionPane.ERROR_MESSAGE);
            //警告对话框
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.QUESTION_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.PLAIN_MESSAGE);
        }
    });

    public void init() {
        jta.append("hello");
        jf.add(jta);
        jf.add(btn, BorderLayout.SOUTH);

        jta.setDebugGraphicsOptions(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new type1().init();
    }
}
//test——accept-成功创建弹出式ERROR对话框
//弹出各种对话框
