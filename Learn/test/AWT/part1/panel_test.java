package test.AWT.part1;

import java.awt.*;

public class panel_test {
    public static void main(String[] args) {
        Frame f=new Frame("TEST_panel");

        //下列为创建panel
        Panel p=new Panel();
        p.add(new TextField("这里是一个测试文本"));
        p.add(new Button("这是测试按钮"));
        p.add(new Button("here is a new button"));
        //编码不统一：文本信息可以正确显示
        //button是由windows创建，本地为中文window系统，gbk
        //测试与演示均使用英文即可

        f.add(p);

        f.setBounds(100,100,500,300);
        f.setVisible(true);
    }
}
//pane是一个容器，可以将其他组件加入其中，再将pane加入到Frame中进行显示
