package test.SWING.Part1.Border_test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class title_border_tes {

    public static void main(String[] args) {
        Frame frame = new Frame("TitledBorderDemo");

        // 创建一个标题为“test_title”的 TitledBorder 对象
        TitledBorder tb = new TitledBorder(BorderFactory.createEtchedBorder(), "test_title", TitledBorder.LEFT, TitledBorder.BOTTOM, new Font("StSong", Font.BOLD, 18), Color.BLUE);

        // 将 TitledBorder 对象设置为窗口的边框
        JPanel jp = new JPanel();
        jp.setBorder(tb);
        frame.add(jp);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
/*
* border：用于创建标题的边框。
title：标题的文本。
justification：标题的水平对齐方式。可以使用以下值：
TitledBorder.LEFT：左对齐。
TitledBorder.CENTER：居中对齐。
TitledBorder.RIGHT：右对齐。
position：标题的垂直位置。可以使用以下值：
TitledBorder.TOP：顶部。
TitledBorder.BOTTOM：底部。
TitledBorder.CENTER：居中。
font：标题的字体。
color：标题的颜色。
* */