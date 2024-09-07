package test.AWT.part3.PopupMenu_test;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class test2 {

    private Frame frame = new Frame("PopupMenu_test");

    //创建PopubMenu菜单
    private PopupMenu popupMenu = new PopupMenu();

    //创建菜单条

    private MenuItem commentItem = new MenuItem("comment");
    private MenuItem cancelItem = new MenuItem("cannelcomment");
    private MenuItem copyItem = new MenuItem("copy");
    private MenuItem pasteItem = new MenuItem("save");


    //创建一个文本域
    private TextArea ta = new TextArea("hello", 6, 40);

    //创建一个Panel
    private  Panel panel = new Panel();

    public void init(){

        //把菜单项添加到PopupMenu中
        popupMenu.add(commentItem);
        popupMenu.add(cancelItem);
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);

        //设置panel大小
        panel.setPreferredSize(new Dimension(300,100));

        //把PopupMenu添加到panel中
        panel.add(popupMenu);

        //为panel注册鼠标事件
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean flag = e.isPopupTrigger();
                //判断当前鼠标操作是不是触发PopupMenu的操作
                if (flag){
                    //让PopupMenu显示在panel上，并且跟随鼠标事件发生的地方显示
                    popupMenu.show(panel,e.getX(),e.getY());
                    //右键点击出现PopupMenu
                    //点击弹出式菜单
                }
            }
        });

        //把ta添加到frame中间区域中

        frame.add(ta);

        //把panel添加到frame底部
        frame.add(panel,BorderLayout.SOUTH);

        //设置frame最佳大小，并可视；
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new test2().init();
    }

}