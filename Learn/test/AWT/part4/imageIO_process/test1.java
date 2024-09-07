package test.AWT.part4.imageIO_process;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//功能实现：本地文件图片查看，另存
public class test1 {
    Frame f = new Frame("image_file_test");
    //创建窗口
    BufferedImage image;

    //创建image承载对象
    //顾名思义：缓冲流iamge
    class Mycanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if (image != null) {
                //image不为空，从0 0 处绘制image
                g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
                //如果image不为空，就重0 0 处开始绘制image
            }
        }
    }

    Mycanvas imageComponent = new Mycanvas();
    //自定义的绘画对象类
    //绘制image

    public void init() {
        MenuBar mb = new MenuBar();
        //创建菜单栏
        Menu menu = new Menu("File");
        //创建菜单
        MenuItem openItem = new MenuItem("open");
        MenuItem saveItem = new MenuItem("sava to");
        //创建菜单词条
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog oDialog = new FileDialog(f);
                oDialog.setVisible(true);
                //文件对话框
                String dir = oDialog.getDirectory();
                String file = oDialog.getFile();
                //获取路径及文件名称
                try {
                    image = ImageIO.read(new File(dir, file));
                    imageComponent.repaint();
                    //调用自定义画布，绘制image
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog sDialog = new FileDialog(f, "sava_image", FileDialog.SAVE);
                sDialog.setVisible(true);

                String dir = sDialog.getDirectory();
                String file = sDialog.getFile();

                try {
                    ImageIO.write(image, "jpg", new File(dir, file));
                    //调用iamgeIO流 保存image_file
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        mb.add(menu);

        menu.add(openItem);
        menu.add(saveItem);

        f.setMenuBar(mb);
        f.add(imageComponent);

        f.setBounds(0,0,800,600);

        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new test1().init();
    }
}
