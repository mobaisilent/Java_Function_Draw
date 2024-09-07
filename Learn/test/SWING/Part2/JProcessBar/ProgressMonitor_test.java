package test.SWING.Part2.JProcessBar;

import  javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ProgressMonitor;

public class ProgressMonitor_test {

    Timer timer;

    public void init() {
        final SimulatedActivity sa = new SimulatedActivity(100);
        final Thread targetThread = new Thread(sa);
        targetThread.start();
        //创建线程任务：多因为Runable接口
        ProgressMonitor dialog = new ProgressMonitor(null, "等待任务完成", "已完成：", 0, sa.getAmount());
        //实例创建对象与自己定义的类名重复了导致错误
        /*
        * null：表示对话进度条不显示在任何容器中。
        "等待任务完成"：表示对话进度条的标题。
        "已完成："：表示对话进度条的状态栏文本。
        0：表示进度条的初始值。
        simulatedActivity.getAmount()：表示进度条的最大值。
        * */
        //这种进度条一次就设置好了，少了一点其他自定义操作，稍微简洁一点点F
        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setProgress(sa.getCurrent());
                if (dialog.isCanceled()){
                    timer.stop();
                    targetThread.interrupt();
                    System.exit(0);
                }
            }
        });
        timer.start();
        //有时候AWT中的Timer和SWIGN中的Tiemr混淆：注意辨别这种情况

        System.out.println("aaa");
    }

    public static void main(String[] args) {
        new ProgressMonitor_test().init();
    }

    private class SimulatedActivity implements Runnable {
        //内存可见
        private volatile int current = 0;
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

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public void run() {
            //通过循环，不断的修改current的值，模拟任务完成量
            while (current < amount) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                current++;
            }
        }
    }
}
