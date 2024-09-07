package test.AWT.part2.Event_Action;

import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class test2 {

    public static void main(String[] args) {
        Frame frame = new Frame("这里测试监听器");

        //创建一个单行文本域
        TextField tf = new TextField(30);
        tf.setText("hello");

        //给文本域添加TextListener，监听内容的变化
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                System.out.println("当前内容：" + tf.getText());
            }
        });


        //给frame注册ContainerListener监听器，监听容器中组件的添加
        frame.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println("容器中添加了新组件：" + child);
            }
        });


        //添加tf到frame
        frame.add(tf);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }
}
//frame的事件监控测试成功