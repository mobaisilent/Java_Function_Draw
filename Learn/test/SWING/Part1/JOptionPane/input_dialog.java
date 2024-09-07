package test.SWING.Part1.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class input_dialog {

    JFrame jf=new JFrame("input_dialog");

    JTextArea jta=new JTextArea(6,30);

    JButton jb=new JButton(new AbstractAction("pop_input_message_dialog") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String result=JOptionPane.showInputDialog(jf,"please input your user name","input_dialog",JOptionPane.INFORMATION_MESSAGE);
            if(result!=null){
                jta.append("\n"+result.toString());
            }
        }
    });

    public void init(){
        jta.append("hello");
        jf.add(jta);
        jf.add(jb, BorderLayout.SOUTH);

        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new input_dialog().init();
    }
}
