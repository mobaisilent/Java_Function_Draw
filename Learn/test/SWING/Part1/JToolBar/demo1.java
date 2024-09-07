package test.SWING.Part1.JToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class demo1 {
    JFrame jf=new JFrame("Test_JToolBar");

    JTextArea jta=new JTextArea(6,35);
    //文本域空间

    JToolBar jtb=new JToolBar();

    Action pre=new AbstractAction("PreOne") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("PreOne\n");
        }
    };

    Action pause=new AbstractAction("Pause") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("Pause\n");
        }
    };

    Action next=new AbstractAction("NextOne") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("Next\n");
        }
    };

    public  void init(){
        jf.add(new JScrollPane(jtb));
        //创建滚动JPanel容器承载jtb

        //创建Button：并且将Action添加到Button中

        JButton pb=new JButton(pre);
        JButton pab=new JButton(pause);
        JButton nb=new JButton(next);

        jtb.add(pb);
        jtb.addSeparator();
        jtb.add(pab);
        jtb.addSeparator();
        jtb.add(nb);
        //向工具条中添加三个按键和间隔

        jf.add(jtb, BorderLayout.NORTH);
        jf.add(jta);
        //TextArea填充6行之后无法继续像下面填充文本信息

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new demo1().init();
    }
}
//创建成功：工具条：Action
