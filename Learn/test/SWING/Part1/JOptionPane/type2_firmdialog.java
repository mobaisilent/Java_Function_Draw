package test.SWING.Part1.JOptionPane;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class type2_firmdialog {

    JFrame jf=new JFrame("firmdialog_test");

    JTextArea jta=new JTextArea(6,30);
    //6行30列的文本域空间

    JButton jtn=new JButton(new AbstractAction("pop_firm_message_button") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result=JOptionPane.showConfirmDialog(jf,jta.getText(),"fime_dialog",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            //将打开的询问对话框选择的结果放到result处
            //5个对象分别为：
            //承载窗口窗口，文本消息，标题，选项，弹出窗口类型
            if(result==JOptionPane.YES_OPTION){
                jta.append("\nuser click the yes button");
            }
            else {
                jta.append("\nuser click the no button or else");
            }
        }
    });

    public void init(){
        jta.append("hello");
        jf.add(jta);
        jf.add(jtn, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new type2_firmdialog().init();
    }
}
//成功弹出询问对话框
