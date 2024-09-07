package test.SWING.Part2.JProcessBar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class demo2 {

    JFrame jf = new JFrame("test_processbar_thread");
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

        SimulatedActivity sa = new SimulatedActivity(100);
        new Thread(sa).start();
        //创建线程任务
        //开启线程

        bar.setMinimum(0);
        bar.setMaximum(sa.getAmount());
        //qqbar.setValue(sa.getCurrent());
        //为什么不用定时器去抓取进度条那么为什么进度条始终为0?
        Timer timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bar.setValue(sa.getCurrent());
            }
        });
        timer.start();

        bar.setStringPainted(true);
        //绘制完成百分比

        bar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (bar.getValue() == bar.getMaximum()) {
                    timer.stop();
                }
            }
        });

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

    }

    private class SimulatedActivity implements Runnable {
        private volatile int current = 0;
        //表示易变int类型变量：并且同时可以被多个线程访问
        private int amount;

        public SimulatedActivity(int amount) {
            this.amount = amount;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getAmount() {
            return amount;
        }

        @Override
        public void run() {
            while (current < amount) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                current++;
            }
        }
        //模拟任务完成量
    }

    public static void main(String[] args) {
        new demo2().init();
    }
}
//更新进度条的处理逻辑：用线程数去处理进度条的值

//一下涉及线程安全的问题
/*
* 在上述代码中，Timer 的作用是每隔指定的时间（在本例中是 300 毫秒）发送一个 ActionEvent 事件。

在 Timer 的 actionPerformed() 方法中，我们调用 bar.setValue() 方法来设置进度条的值。

如果不使用 Timer，那么进度条的值将不会被更新。这是因为 SimulatedActivity 类中的 current 变量是线程安全的，但是 bar.setValue() 方法不是线程安全的。如果多个线程同时调用 bar.setValue() 方法，那么可能会导致进度条的值不正确。

因此，使用 Timer 可以确保进度条的值在指定的时间间隔内更新一次，从而避免进度条的值不正确。

具体来说，在上述代码中，Timer 的 actionPerformed() 方法每隔 300 毫秒就会被调用一次。在 actionPerformed() 方法中，我们调用 bar.setValue() 方法来设置进度条的值为 SimulatedActivity 类中的 current 变量的值。

由于 current 变量是线程安全的，因此多个线程同时调用 actionPerformed() 方法也不会导致进度条的值不正确。

因此，使用 Timer 可以解决进度条不正确的问题。
* */
