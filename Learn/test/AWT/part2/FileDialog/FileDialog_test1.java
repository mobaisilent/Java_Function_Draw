package test.AWT.part2.FileDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialog_test1 {
    public static void main(String[] args) {
        Frame f=new Frame("here test FileDialog");
        //先创建窗口

        FileDialog fd1=new FileDialog(f,"chosing loading file",FileDialog.LOAD);
        //Dialog不可单独存在，必须依赖某个框架存在
        FileDialog fd2=new FileDialog(f,"chsing saving file",FileDialog.SAVE);

        Button b1=new Button("open file");
        Button b2=new Button("sava file");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd1.setVisible(true);
                String pace=fd1.getDirectory();
                String name=fd1.getName();
                System.out.println("选择的文件路径为："+pace);
                System.out.println("选择文件的名称为:"+name);
            }
        });

        f.add(b1,BorderLayout.NORTH);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd2.setVisible(true);
                String pace=fd2.getDirectory();
                String name=fd2.getName();
                System.out.println("选择的文件路径为："+pace);
                System.out.println("选择文件的名称为:"+name);
            }
        });

        f.add(b2);

        f.pack();
        f.setVisible(true);
    }
}
//两个文件选择框创建成功，及成功打开文件选择框与文件保存框
