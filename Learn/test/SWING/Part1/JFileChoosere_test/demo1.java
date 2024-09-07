package test.SWING.Part1.JFileChoosere_test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class demo1 {
    JFrame jf=new JFrame("JFileChooser_test");
    //创建窗口

    JFileChooser chooser=new JFileChooser(".");
    //创建文件对话框，从 “.” 路径大打开文件选择器

    JMenuBar jmb=new JMenuBar();
    //创建菜单条

    JMenu jMenu=new JMenu("file");
    //创建菜单项

    JMenuItem open=new JMenuItem(new AbstractAction("open") {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.showOpenDialog(jf);
            //创建条目的同时打开文件选择器Action
            //打开文件选择框：依托于jf窗口
            File imageFile=chooser.getSelectedFile();
            //将选择的文件对象存到imageFile处 （File文件类型）
            try {
                image= ImageIO.read(imageFile);
                //readimage ：随后将image绘制到drawArea处
                //先读取image文件
                drawArea.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    //创建open按钮：打开文件对话框

    JMenuItem save=new JMenuItem(new AbstractAction("save_as") {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);;
            //设置模式：仅显示目录
            chooser.showSaveDialog(jf);
            //打开文件选择框：sava
            File dir=chooser.getSelectedFile();
            //获取select的文件目录
            //上诉三步简记为设置模式：打开窗口，获得路径：下面即为保存
            try {
                ImageIO.write(image,"jpeg",new File(dir,"a.jpg"));
                //在dir目录下保存a.jpg
                //自定义文件名称及文件类型
                //用ImageIO中的write方法存取文件
                //将image对象保存到dir目录下，名称为a.jpg，保存方式为jpeg
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    //创建保存菜单按钮
    BufferedImage image;
    //创建图像缓冲流对象

    JPanel drawArea=new Mycanvas();

    class Mycanvas extends JPanel{
        @Override
        public void paint(Graphics g){
            if(image!=null){
                g.drawImage(image,0,0,null);
                //绘制image，从左上角的位置0 0 处开始绘制
                //图像监视器设置为null
            }
        }
    };
    //创建内部类
    //为什么是继承Jpanel对象？

    public  void init(){
        //图像及窗口初始化
        drawArea.setPreferredSize(new Dimension(500,300));
        // 设置优选大小为500 300
        jf.add(drawArea);

        jMenu.add(open);
        jMenu.add(save);
        jmb.add(jMenu);
        jf.setJMenuBar(jmb);
        //将jmb设置为jf的菜单条

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置默认关闭操作
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new demo1().init();
    }
}
//文件对话框创建成功：基本功能实现：打开image文件以及另存为功能实现
