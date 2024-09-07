package test.AWT.part2.Event_Action;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Windows_close_Listener {
    public static void main(String[] args) {
        Frame f=new Frame("test_windows_listener");

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //WindowListener监控器有open事件，也有close事件

        f.setBounds(200,300,500,300);
        f.setVisible(true);
    }
}
