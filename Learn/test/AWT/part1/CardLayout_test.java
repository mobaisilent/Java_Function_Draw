package test.AWT.part1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayout_test {
    public static void main(String[] args) {
        Frame f=new Frame();
        f.setVisible(true);

        CardLayout c=new CardLayout();
        Panel p1=new Panel();
        p1.setLayout(c);;
        //P1.setLayout(new CardLayout());
        //相当于将c的布局加入到p1中
        String[] names={"first","second","third","forth","fifth"};

        for(int i=0;i<names.length;i++){
            p1.add(names[i],new Button(names[i]));
            //前者为p1中每个Card的名字，后者为内容
        }
        f.add(p1);
        Panel p2=new Panel();

        Button b1=new Button("Previous");
        Button b2=new Button("Next");
        Button b3=new Button("First");
        Button b4=new Button("Last");
        Button b5=new Button("Third");

        //创建监控器：检测每次的点击行为
        ActionListener l=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCmd=e.getActionCommand(); //这个字符串为按钮上的文字
                switch (actionCmd){
                    case "Previous":
                        c.previous(p1);  //对c进行操作  //显示previous的那张
                        break;           //卡片布局器其内部自带的函数
                    case "Next":
                        c.next(p1);
                        break;
                    case "First":
                        c.first(p1);
                        break;
                    case "Last":
                        c.last(p1);
                        break;
                    case "Third":
                        c.show(p1,"third");
                        break;
                }
            }
        };
        //接口类 自动Override

        //将5个按键与l进行绑定 l见前面的定义
        b1.addActionListener(l);
        b2.addActionListener(l);
        b3.addActionListener(l);
        b4.addActionListener(l);
        b5.addActionListener(l);
        //将5个按钮与监视器l进行绑定，那么监视器l即可读取到每个按钮上的字符串了

        //将5个按键添加到p2中
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

        f.add(p2, BorderLayout.SOUTH);

        f.pack();
    }
}
//卡片测试以及啊卡片切换
//如果一直按next可以重新回到第一张然后开始新的一轮
//卡片布局，其流程还是需要记忆的
