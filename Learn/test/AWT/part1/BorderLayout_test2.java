package test.AWT.part1;

import java.awt.*;

public class BorderLayout_test2 {
    public static void main(String[] args) {
        Frame f = new Frame("borderlayout_test2");

        f.setLayout(new BorderLayout(30, 10));
        f.setVisible(true);
        f.setBounds(100,100,500,300);

        f.add(new Button("North"), BorderLayout.NORTH);
        f.add(new Button("South"), BorderLayout.SOUTH);

        Panel p=new Panel();
        p.add(new Button("center_botton"));
        p.add(new TextField("test_text"));
        //Panel是一个容器

        //在Border中，如果未设置区块，则自动放入center区块中

        f.add(p);

        f.pack();
    }
}
