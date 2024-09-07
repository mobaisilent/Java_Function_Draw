package test.SWING.Part2.JTabledPane;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTabbedPaneTest {
    JFrame jf = new JFrame("测试JTabbedPane");
    //创建窗口
    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
    //创建JTabbedPane对象
    //SwingConstants.TOP：表示选项卡的布局方向为顶部。
    //JTabbedPane.WRAP_TAB_LAYOUT：表示选项卡面板的布局方式为自动换行。

    public void init() {
        //设置jf大小
        jf.setBounds(400, 400, 400, 400);
        //设置jf大小不能变化
        jf.setResizable(false);


        ImageIcon icon = new ImageIcon();
        //添加标签
        tabbedPane.addTab("用户管理", icon, new JList<String>(new String[]{"用户一", "用户二", "用户三"}));
        tabbedPane.addTab("商品管理", new JList<String>(new String[]{"商品一", "商品二", "商品三"}));
        tabbedPane.addTab("订单管理", icon, new JList<String>(new String[]{"订单一", "订单二", "订单三"}));
        //标签 名称：图标：以及列表清单

        //设置第二个标签默认选中
        tabbedPane.setSelectedIndex(1);

        //设置第一个标签不可用
        tabbedPane.setTabComponentAt(0, new JLabel());
        ///将第一个选项卡的 tabComponent 属性设置为一个空的 JLabel 对象
        //0表示下标

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                //获取下标0 1 2
                JOptionPane.showMessageDialog(jf, "选中了第" + (selectedIndex + 1) + "个标签");
            }
        });
        //设置监控器：当点击上面一栏标签的时候弹处messagedialog

        jf.add(tabbedPane);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        //设置jf

    }

    public static void main(String[] args) {
        new JTabbedPaneTest().init();
    }
}
