package test.SWING.Part1.Border_test;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class border_test {
    JFrame jf=new JFrame("Border_test");

    public void init(){
        jf.setLayout(new GridLayout(2,4));
        //为jf设置网络布局管理器
        //共计两行四列

        Border bb=BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY);
        jf.add(getPanelWithBorder(bb,"BevelBorder"));
        //设置凸起的边框块：添加到jf中

        Border lb=BorderFactory.createLineBorder(Color.ORANGE,10);
        jf.add(getPanelWithBorder(lb,"LineBorder"));
        //设置Lineborder块，添加到jf中

        Border eb=BorderFactory.createEmptyBorder(20,5,10,30);
        jf.add(getPanelWithBorder(eb,"EmptyBorder"));
        //四个参数分别表示上左下右边框的宽度
        //设置空白边框

        Border etb=BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.RED,Color.GREEN);
        jf.add(getPanelWithBorder(etb,"EtcheBorder"));
        //设置EtcheBorder边框
        //建凹凸效果的边框。它使用了一种称为 “阴影” 的技术来创建这种效果。

        TitledBorder tb=new TitledBorder(lb,"test_title",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong",Font.BOLD,18),Color.BLUE);
        jf.add(getPanelWithBorder(tb,"TitleBorder"));
        //直接创建TitleBorder
        //传递的对象为LineBorder

        MatteBorder mb=new MatteBorder(20,5,10,30,Color.GREEN);
        jf.add(getPanelWithBorder(mb,"MatteBorder"));
        //上左下右边框以及填充色、
        //带有颜色填充的边框

        CompoundBorder cb=new CompoundBorder(new LineBorder(Color.RED,8),tb);
        jf.add(getPanelWithBorder(cb,"CompoundBorder"));
        //将两个边框组合成新边框
        //有一种大边框包围小边框的感觉

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

    }
    public JPanel getPanelWithBorder(Border border,String borderName){
        //传入一个border和一个名称（label：标签）
        JPanel jPanel=new JPanel();
        //设置Jpanel

        jPanel.add(new JLabel(borderName));

        jPanel.setBorder(border);
        //为panel设置边框
        //原理：为一个panel块设置边框setBorder

        return jPanel;
    }
    //自定义方法：返回对象为Jpanel

    public static void main(String[] args) {
        new border_test().init();
    }
}
//创建各种各样的边框
//每个边框的承载对象为Panel
//用GridLayout将JFrame分割为多个小块
//每个块中填充带边框的Panel即可