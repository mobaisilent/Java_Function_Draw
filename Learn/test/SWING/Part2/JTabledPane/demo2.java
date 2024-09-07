package test.SWING.Part2.JTabledPane;

import javax.swing.*;

public class demo2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JTabbedPane 示例");

        // 创建 JTabbedPane 对象
        JTabbedPane tabbedPane = new JTabbedPane();

        // 为 JTabbedPane 对象添加组件
        tabbedPane.addTab("用户管理", new JList<String>(new String[]{"用户一", "用户二", "用户三"}));
        tabbedPane.addTab("商品管理", new JList<String>(new String[]{"商品一", "商品二", "商品三"}));
        tabbedPane.addTab("订单管理", new JList<String>(new String[]{"订单一", "订单二", "订单三"}));

        // 设置 JTabbedPane 对象的属性
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // 将 JTabbedPane 对象添加到窗口
        frame.add(tabbedPane);

        // 设置窗口的大小和位置
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        // 设置窗口的关闭操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗口
        frame.setVisible(true);
    }
}
//该代码创建了一个 JTabbedPane 对象，并为其添加了三个组件。每个组件都是一个 JList 对象，其中包含一些文本。tabbedPane 对象的布局策略设置为滚动，这样，如果选项卡面板的宽度不足以显示所有选项卡，则可以滚动显示。
//运行该代码后，将会出现一个窗口，窗口中包含三个选项卡。用户可以通过点击选项卡来切换显示不同的组件。
