package test.SWING.Part2.JSplitPane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class SplitPaneTest {

    Book[] books = {new Book("java自学宝典", null, "国内关于 Java 编程最全面的图书 \n 看得懂 ， 学得会"),

            new Book("轻量级的JAVAEE企业应用实战", null, "SSM整合开发的经典图书，值的拥有"),

            new Book("Android基础教程", null, "全面介绍Android平台应用程序\n 开发的各方面知识")
    };
    //创建Book对象数组：
    //名称，图标，内容
    //带参构造方式

    JFrame jf = new JFrame("测试JSplitPane");
    //创建窗口

    //列表展示图书
    JList<Book> bookList = new JList<>(books);
    //创建列表：用于展示：用数组创建列表

    JLabel bookCover = new JLabel();

    JTextArea bookDesc = new JTextArea();

    public void init() {

        //为三个组件设置最佳大小
        bookList.setPreferredSize(new Dimension(150, 400));
        bookCover.setPreferredSize(new Dimension(220, 330));
        bookDesc.setPreferredSize(new Dimension(220, 70));
        //书名清单
        //书封面内容
        //书的内容 设置窗口大小


        //为列表添加事件监听器
        bookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Book book = bookList.getSelectedValue();
                bookCover.setIcon(book.getIcon());
                bookDesc.setText(book.getDesc());
                //直接传值
            }
        });

        //创建一个垂直的分割面板
        JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bookCover, new JScrollPane(bookDesc));
        //将内容和封面添加进入其中

        //打开"一触即展"特性
        left.setOneTouchExpandable(true);
        //向上展开或者向下展开

        //设置分隔条的大小
        left.setDividerSize(10);
        //设置分割面板根据组件的大小调整最佳布局
        left.resetToPreferredSizes();

        //创建一个水平分隔面板
        JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, bookList);
        //以left和booklist创建第二个分隔面板content：，content就实现了将bookCover，bookDesc和bookLit全部放到一起
        //设置支持连续布局
        content.setContinuousLayout(true);

        jf.add(content);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);


    }

    public static void main(String[] args) {
        new SplitPaneTest().init();
    }

}
//将image全部替换为null表示为空或者无图像的意思
//创建JSplitPane的四步操作
//创建对象
//创建分隔条的大小
//创建展开
//设置最佳布局