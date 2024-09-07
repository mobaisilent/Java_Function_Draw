package test.AWT.part3.MenuBar_test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class test1 {
    private Frame f=new Frame("MenuBar_test");

    MenuBar menuBar=new MenuBar();
    //整合类组件

    //下列创建菜单组件
    Menu filemenu=new Menu("File");

    Menu editmenu=new Menu("Edit");

    MenuItem newfile=new MenuItem("creat_newfile");
    MenuItem save=new MenuItem("save");
    MenuItem back=new MenuItem("back");

    MenuItem auto=new MenuItem("auto\\n");
    MenuItem copy=new MenuItem("copy");
    MenuItem paste=new MenuItem("paste");

    Menu style=new Menu("Style");

    MenuItem comment=new MenuItem("comment",new MenuShortcut(KeyEvent.VK_Q,true)); //表示用ctrl+q+shift
    MenuItem cannelcomment=new MenuItem("cannelcomment");

    //文本域
    TextArea ta=new TextArea(6,30);
    //后续超过了6行可以继续追加

    public  void init(){
        filemenu.add(newfile);
        filemenu.add(save);
        filemenu.add(back);

        editmenu.add(auto);
        editmenu.add(copy);
        editmenu.add(paste);
        editmenu.add(style);

        style.add(comment);
        style.add(cannelcomment);

        menuBar.add(filemenu);
        menuBar.add(editmenu);

        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("you clicked the"+e.getActionCommand()+"\n");
                //向后追加内容
            }
        });

        f.setMenuBar(menuBar);
        f.add(ta);

        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new test1().init();
    }
}
