package test.SWING.Part2.JSplitPane;

import  javax.swing.*;
import  java.awt.*;
public class Book {

    private String name;

    private Icon icon;

    private String desc;

    public Book(String name, Icon icon, String desc) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name;
    }
}
//一个自定义的javabean类：实现Book对象，以及对Book对象的各种操作