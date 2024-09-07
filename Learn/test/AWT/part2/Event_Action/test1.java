package test.AWT.part2.Event_Action;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test1 {
    public static void main(String[] args) {
        new Action().init();
        //创建对象，并且调用方法
    }
}
class Action{
    Frame f=new Frame();

    Button b1=new Button("CLICK");
    //事件源
    TextField tf=new TextField(30);
    //30列的单条文本框
    public  void init(){
        b1.addActionListener(new MyActionListener());
        //注册监听：但是暂且不进行构建
        f.add(tf);
        f.add(b1,BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);
    }
    private  class MyActionListener implements ActionListener{
        //自定义一个私有类 继承ActionListener 实现外部进行覆写 （类及其私有类及其接口的使用）
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("user clicked button");
            tf.setText("hello");
        }
    }
}
//测试成功：交互成功
