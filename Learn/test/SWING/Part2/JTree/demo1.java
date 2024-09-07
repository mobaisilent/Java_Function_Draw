package test.SWING.Part2.JTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class demo1 {

    JFrame jf = new JFrame("easy_tree_by_java");

    JTree tree;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode guangdong;
    DefaultMutableTreeNode guangxi;
    DefaultMutableTreeNode foshan;
    DefaultMutableTreeNode shantou;
    DefaultMutableTreeNode guiin;
    DefaultMutableTreeNode nanning;

    public void init() {
        root=new DefaultMutableTreeNode("中国");
        guangdong=new DefaultMutableTreeNode("广东");
        guangxi=new DefaultMutableTreeNode("广西");
        foshan=new DefaultMutableTreeNode("佛山");
        shantou=new DefaultMutableTreeNode("汕头");
        guiin=new DefaultMutableTreeNode("桂林");
        nanning=new DefaultMutableTreeNode("南宁");

        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guiin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        tree=new JTree(root);

        jf.add(new JScrollPane(tree));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new demo1().init();
    }
}
//创建文件夹树
