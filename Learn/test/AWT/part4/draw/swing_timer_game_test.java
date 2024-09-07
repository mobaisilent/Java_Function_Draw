package test.AWT.part4.draw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class swing_timer_game_test {
    final int WINDOW_WIDTH = 300;
    final int WINDOW_HEIGHT = 400;

    final int PACKET_WIDTH = 60;
    final int PACKET_HEIGHT = 20;

    int BALL_SIZE = 26;

    int BALL_X_SPEED = 10;
    int BALL_Y_SPEED = 5;

    int BALL_X = 120;
    int BALL_Y = 20;

    int PACKET_X = 120;
    final int PACKET_Y = 340;

    boolean flag = true;

    Timer t = new Timer(50, null); // 使用 Swing 的 Timer，而不是 java.util.Timer
    //50ms刷新一次

    Mycanvas mc = new Mycanvas();

    Frame f = new Frame("ball_game_test");

    public void init() {
        mc.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        f.add(mc);

        KeyListener kl = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int korder = e.getKeyCode();
                if (korder == KeyEvent.VK_LEFT) {
                    if (PACKET_X > 0) {
                        PACKET_X -= 10;
                    }
                } else if (korder == KeyEvent.VK_RIGHT) {
                    if (PACKET_X < mc.getWidth() - PACKET_WIDTH) {
                        PACKET_X += 10;
                    }
                }
            }
        };
        //定义按键监视器：感觉这个按键监视器有阻塞导致板的移动有明显的卡顿感
        f.addKeyListener(kl);
        mc.addKeyListener(kl);

        ActionListener timeTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (BALL_X < 0 || BALL_X > WINDOW_WIDTH - BALL_SIZE) {
                    BALL_X_SPEED = -BALL_X_SPEED;
                }
                if (BALL_Y < 0 || BALL_X >= PACKET_X && BALL_X <= PACKET_X + PACKET_WIDTH && BALL_Y >= PACKET_Y - BALL_SIZE) {
                    BALL_Y_SPEED = -BALL_Y_SPEED;
                } else if (BALL_Y > PACKET_Y && (BALL_X < PACKET_X || BALL_X > PACKET_X + PACKET_WIDTH)) {
                    t.stop();
                    flag = false;
                    mc.repaint();
                }

                BALL_X += BALL_X_SPEED;
                BALL_Y += BALL_Y_SPEED;

                mc.repaint();
            }
        };

        t.addActionListener(timeTask);
        t.start();

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new swing_timer_game_test().init();
    }

    private class Mycanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if (flag == false) {
                g.setColor(Color.BLUE);
                g.setFont(new Font("Times", Font.BOLD, 30));
                //BOLD设置粗体，30表示字体大小
                /*
                * new Font("Times", Font.BOLD, 30)：这是创建一个新的 Font 对象的代码。Font 类在 Java 中用于表示字体，它的构造函数接受三个参数：

                    第一个参数 "Times" 是字体名称，表示使用 Times 字体。
                    第二个参数 Font.BOLD 是字体样式，表示使用粗体。Font 类中定义了几种样式，包括 Font.PLAIN（普通）、Font.BOLD（粗体）和 Font.ITALIC（斜体）。这些样式可以通过逻辑 OR 运算符组合在一起，例如 Font.BOLD | Font.ITALIC 表示粗斜体。
                    第三个参数 30 是字体大小，表示字体的点数，这是一个表示字体视觉高度的度量单位
                * */
                g.drawString("GAMEOVER!！", 50, 200);
                //按照上面的Color和Font设置 字符串样式
                //在x，y的位置处绘制GAMEOVER!!
            } else {
                g.setColor(Color.RED);
                g.fillOval(BALL_X, BALL_Y, BALL_SIZE, BALL_SIZE);

                g.setColor(Color.PINK);
                g.fillRect(PACKET_X, PACKET_Y, PACKET_WIDTH, PACKET_HEIGHT);
            }
        }
    }
}
