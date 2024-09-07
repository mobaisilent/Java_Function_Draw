package practice;

import javax.swing.*;

public class ShowDialog {
    public void showEnterWarningDialog(JFrame jf){
        String message = "你输入了错误的函数表达式！\n正确的函数表达式如下：\n" +
                "y=x\n" +
                "y=sinx 或 y=sin(x)\n"+
                "y=cosx 或 y=cos(x)\n"+
                "y=tanx\n"+
                "y=x^2\n" +
                "y=2^x\n"+
                "y=sinx+x^2+2^x\n"+
                "......";
        JOptionPane.showMessageDialog(jf, message, "WARNING", JOptionPane.WARNING_MESSAGE);
    }
    public void showEmptyWarningDialog(JFrame jf){
        JOptionPane.showMessageDialog(jf, "请输入函数表达式！", "WARNING", JOptionPane.WARNING_MESSAGE);
    }
    public void showScaleMessageDialog(JFrame jf){
        JOptionPane.showMessageDialog(jf, "尺寸过大/过小\n" +
                "scale>=0.25 && scale<=5", "WARNING", JOptionPane.WARNING_MESSAGE);
    }
}
//用来展示在绘制函数过程中遇见的各种问题
