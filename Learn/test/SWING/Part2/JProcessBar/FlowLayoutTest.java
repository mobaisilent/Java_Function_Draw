package test.SWING.Part2.JProcessBar;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame("FlowLayout 示例");

        // 设置布局管理器
        frame.setLayout(new FlowLayout());

        // 添加组件
        frame.add(new JLabel("标签 1"));
        frame.add(new JButton("按钮 1"));
        frame.add(new JTextField("文本框 1"));

        // 设置窗口的大小和位置
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        //这样设置窗口可以在屏幕中心处显示

        // 设置窗口的关闭操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗口
        frame.setVisible(true);
    }
}
//FlowLayout 是一种流式布局管理器，它将组件从左到右、从上到下依次排列。如果组件无法全部显示，则会自动换行。
