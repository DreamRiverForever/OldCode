import javax.swing.*;

public class DemoFrame extends JFrame {

    //在构造方法中初始化窗体
    public DemoFrame(){
        //----------------------设置窗体大小
        this.setSize(800,600);
        //---------------------------将报表面板添加到窗体中
        this.add(new BarChart().getChartPanel());
        //----------------------设置窗体大小不可变
        this.setResizable(false);
        //----------------------设置窗体相对于屏幕居中
        this.setLocationRelativeTo(null);
        //------------------------设置窗体可见
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DemoFrame();
    }
}