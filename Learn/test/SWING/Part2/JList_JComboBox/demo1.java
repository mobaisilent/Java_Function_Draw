package test.SWING.Part2.JList_JComboBox;

import javax.management.relation.RoleUnresolved;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

public class demo1 {

    JFrame jf = new JFrame("test_list_");

    String[] books = {"java自学宝典", "轻量级javaEE企业应用实战", "Android基础教程", "jQuery实战教程", "SpringBoot企业级开发", "Linux实战教程"};
    //创建String 数组，用来添加到list中

    JList<String> bookList = new JList<>(books);

    JComboBox<String> bookSelector = new JComboBox<>(books);

    JPanel layoutPane1 = new JPanel();
    ButtonGroup layoutGroup = new ButtonGroup();
    //创建 布局选择 按钮

    JPanel selectModePane1 = new JPanel();
    ButtonGroup selectModeGroup = new ButtonGroup();
    //创建 选择模式 按钮

    JTextArea favorite = new JTextArea(4, 40);
    //创建4行40列的文本空间

    public void init() {
        bookList.setVisibleRowCount(3);
        //同时可以展示3个列表项

        bookList.setSelectionInterval(2, 4);
        //设置默认开始展开第3项到第5项（考虑到下标)
        addLayoutButton("纵行滚动", JList.VERTICAL);
        addLayoutButton("纵向换行", JList.VERTICAL_WRAP);
        addLayoutButton("横向换行", JList.HORIZONTAL_WRAP);

        addSelectModeButton("无限制", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addSelectModeButton("单选", ListSelectionModel.SINGLE_SELECTION);
        addSelectModeButton("单范围", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Box listBox = Box.createVerticalBox();
        listBox.add(new JScrollPane(bookList)); //添加的同时创建滚动条
        listBox.add(layoutPane1);
        listBox.add(selectModePane1);

        bookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<String> selectedValuesList = bookList.getSelectedValuesList();
                favorite.setText("");
                for (String s : selectedValuesList) {
                    favorite.append(s+"\n");
                }
            }
        });

        Vector<String> bookCollection=new Vector<>();
        List<String> books= List.of("java自学宝典", "轻量级javaEE企业应用实战", "Android基础教程", "jQuery实战教程", "SpringBoot企业级开发", "Linux实战教程");
        bookCollection.addAll(books);

        bookSelector=new JComboBox<>(bookCollection);

        bookSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem=bookSelector.getSelectedItem();
                favorite.setText(selectedItem.toString());
            }
        });

        bookSelector.setEditable(true);

        bookSelector.setMaximumRowCount(4);
        JPanel panel = new JPanel();
        panel.add(bookSelector);
        Box box = Box.createHorizontalBox();
        box.add(listBox);
        box.add(panel);

        JPanel favoritePanel = new JPanel();
        favoritePanel.setLayout(new BorderLayout());
        favoritePanel.add(new JScrollPane(favorite));
        favoritePanel.add(new JLabel("您最喜欢的图书："),BorderLayout.NORTH);

        jf.add(box);
        jf.add(favoritePanel,BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    //添加布局方向的方法
    public void addLayoutButton(String label, int orientation) {
        layoutPane1.setBorder((new TitledBorder((new EtchedBorder()), "确定选择布局")));
        JRadioButton button = new JRadioButton(label);
        layoutPane1.add(button);
        if (layoutGroup.getButtonCount() == 0) {
            button.setSelected(true);
        }
        layoutGroup.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList.setLayoutOrientation(orientation);
            }
        });
    }
    //该代码定义了一个名为addLayoutButton的方法，该方法用于向布局面板（layoutPane1）中添加一个单选按钮（JRadioButton）。该方法接受两个参数：标签（label）和方向（orientation）。
    //
    //该方法首先创建一个新的TitledBorder并将它应用于layoutPane1。TitledBorder是一个带有边框和标题的边框。标题设置为“确定选择布局”。
    //
    //接下来，该方法创建一个新的JRadioButton并将其添加到layoutPane1中。JRadioButton是一个单选按钮。参数label是按钮的文本。
    //
    //如果layoutGroup中没有按钮，则将该按钮设置为选中状态。layoutGroup是一个ButtonGroup，它用于确保只能选择一个单选按钮。
    //
    //最后，该方法为按钮添加一个ActionListener。ActionListener是一个接口，它用于响应按钮的点击事件。该ActionListener的actionPerformed方法将bookList的布局方向设置为orientation。bookList是一个JList，它用于显示图书列表。
    //
    //总而言之，该代码用于向布局面板中添加一个单选按钮，该按钮用于选择图书列表的布局方向。

    //第一个add方法：将按钮添加到布局面板中，以便它可以显示在布局面板中。
    //第二个add方法：将按钮添加到ButtonGroup中，以便确保只能选择一个单选按钮。

    public void addSelectModeButton(String label, int selectMode) {
        selectModePane1.setBorder(new TitledBorder(new EtchedBorder(), "确定选择模式"));
        JRadioButton button = new JRadioButton(label);
        selectModePane1.add(button);
        if (selectModeGroup.getButtonCount() == 0) {
            button.setSelected(true);
        }
        selectModeGroup.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList.setSelectionMode(selectMode);
            }
        });
    }

    public static void main(String[] args) {
        new demo1().init();
    }
}