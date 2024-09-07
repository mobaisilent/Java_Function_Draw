package test.SWING.Part1.JColor_Chooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class demo1 {
    JFrame jf=new JFrame("ColorChooser_test");
    //创建窗口
    JTextArea jta=new JTextArea("hello",6,30);
    //创建文本域
    JButton button =new JButton(new AbstractAction("changeColor") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color result=JColorChooser.showDialog(jf,"colorChooser",Color.WHITE); //默认从WHITE开始
            jta.setBackground(result);
        }
    });
    //创建按键并且同时添加事件
    //按键的Action是打开颜色选择框：选择一种颜色：并且将文本框的背景设置为选择的颜色，未选择则未默认白色

    public void init(){
        jf.add(jta);

        jf.add(button,BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new demo1().init();
    }
}
//创建颜色选择器：并且为文本框设置背景色
