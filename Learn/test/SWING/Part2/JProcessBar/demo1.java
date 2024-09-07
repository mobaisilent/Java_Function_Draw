package test.SWING.Part2.JProcessBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo1 {

    JFrame jf = new JFrame("test_processbar");
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL);
    //创建进度条，设置进度方向为水平

    JCheckBox indeterminate = new JCheckBox("indeterminate_progress_bar");
    JCheckBox noBorder = new JCheckBox("noBorder");

    public void init() {
        Box box = new Box(BoxLayout.Y_AXIS);  //创建box对象：并且将其方向设置为垂直
        box.add(indeterminate);
        box.add(noBorder);

        jf.setLayout(new FlowLayout());
        //设置流式布局管理器
        jf.add(box);

        bar.setMinimum(0);
        bar.setMaximum(100);
        //从0加载到100的进度条

        bar.setStringPainted(true);
        //绘制完成百分比

        noBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = noBorder.isSelected();
                bar.setBorderPainted(!flag);
                //是否有边框取决于是否勾选了noBorder这个checkBox
            }
        });

        indeterminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = indeterminate.isSelected();
                bar.setIndeterminate(flag);
                //修改进度条的状态：确定状态和不确定状态
                bar.setStringPainted(!flag);
                //是否绘制进度条的值（依据flag）
            }
        });

        jf.add(bar);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

        for(int i=0;i<=100;i++){
            bar.setValue(i);

            try {
                Thread.sleep(1000);
                //每1000ms前进一格
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        new demo1().init();
    }
}
