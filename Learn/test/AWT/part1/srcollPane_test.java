package test.AWT.part1;

import java.awt.*;

public class srcollPane_test {
    public static void main(String[] args) {
        Frame f=new Frame("测试");
        f.setBounds(100,100,500,300);
        f.setVisible(true);

        //创建ScrollPane容器
        ScrollPane sc=new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //始终显示进度条
        sc.add(new TextField("here is test text"));
        //由于布局管理器导致这段 文本段无法显示
        sc.add(new Button("test botton"));

        f.add(sc);

        //创建了一个大按键不知道是干嘛的
    }
}
//ScrollPane是创建滚动面板以显示所有内容
/**
 *
 * ScrollPane.SCROLLBARS_ALWAYS 是一个常量，它指示在ScrollPane中始终显示滚动条。在这种情况下，无论内容是否需要滚动，都会显示滚动条
 */
//容器，显示滚动内容
