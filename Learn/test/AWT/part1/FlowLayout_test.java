package test.AWT.part1;

import java.awt.*;

public class FlowLayout_test {
    public static void main(String[] args) {
        Frame f=new Frame("test FlowLayout");

        //f.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        //没用滚动窗口，需要手动将窗口拖下来

        //test2
        f.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        //居中对齐：test accept

        f.setBounds(100,100,500,300);
        f.setVisible(true);

        for(int i=1;i<=100;i++){
            f.add(new Button("botton"+i));
        }

        f.pack();
    }
}
//flowlayout是将组件水平排列和垂直排列