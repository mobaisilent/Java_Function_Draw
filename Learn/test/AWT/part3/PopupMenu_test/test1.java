package test.AWT.part3.PopupMenu_test;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class test1 {
    private JFrame f = new JFrame("PopupMenu_test");

    JPopupMenu popupMenu = new JPopupMenu();

    //下列创建菜单条
    JMenuItem comment = new JMenuItem("comment"); //注释的英文就是comment
    JMenuItem canclecomment = new JMenuItem("canclecomment");
    JMenuItem copy = new JMenuItem("copy");
    JMenuItem save = new JMenuItem("save");
    //创建4个词条菜单组件

    JTextArea ta = new JTextArea(6, 30);

    JPanel p = new JPanel();


    public void init() {
        ta.setText("hello");
        //设置文本域内容

        popupMenu.add(comment);
        popupMenu.add(canclecomment);
        popupMenu.add(copy);
        popupMenu.add(save);

        //下列语句设置panel的大小
        p.setPreferredSize(new Dimension(300,100));

        p.add(popupMenu);
        //下面为p注册鼠标事件
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                boolean flag = e.isPopupTrigger();
                if (flag) {
                    popupMenu.show(p, e.getX(), e.getY());
                }
            }
        });

        f.add(ta);

        f.add(p, BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new test1().init();
    }
}
