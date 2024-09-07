package test.AWT.part1;

import javax.swing.*;
import java.awt.*;

public class basic_component {
    Frame f = new Frame();
    //创建窗口

    Button b = new Button("YES");
    //创建YES按钮

    CheckboxGroup cbg = new CheckboxGroup();
    //创建一个复选组
    Checkbox male = new Checkbox("MAN", cbg, true);
    //创建一个单个的选择框：加入到cbg中
    Checkbox female = new Checkbox("WOMAN", cbg, false);
    //创建一个单个的选择框，加入到cbg中

    Checkbox married = new Checkbox("Married?", false);
    //创建一个单选框：始终是未选中状态

    Choice c = new Choice();
    //定义一个下拉选择框

    List list = new List(6, true);
    //定义一个列表选择框

    TextArea ta = new TextArea(5, 20);
    //定义一个5行20列的文本框

    TextField tf = new TextField(50);
    //创建一个50列的单行文本框

    public void init() {
        c.add("RED");
        c.add("GREEN");
        c.add("BLUE");
        //向下拉选择框中添加内容

        list.add("RED");
        list.add("GREEN");
        list.add("BLUE");
        //向列表框中添加内容

        Panel p1 = new Panel();
        p1.add(tf);
        p1.add(b);
        f.add(p1, BorderLayout.SOUTH);
        //将单行文本框添加到一个容器中，再将容器置于Frame的南部区域

        Panel p2 = new Panel();
        p2.add(c);
        p2.add(male);
        p2.add(female);
        p2.add(married);
        //装载下拉文本框，单选框和复选框

        Box bb = Box.createVerticalBox();
        bb.add(ta);
        bb.add(p2);
        //一个垂直box 上部为文本域空间，其下为复选框区间

        Box vbox = Box.createHorizontalBox();
        vbox.add(bb);
        vbox.add(list);
        //创建一个水平Box，左边额外Box bb，右边为列表区间

        f.add(vbox);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new basic_component().init();

    }

    ;
}
//大型框架创建成功