import java.awt.GridLayout;

import javax.swing.JFrame;

public class mainClass {
public static void main(String args[]){
	JFrame frame=new JFrame("Java数据统计图");
	frame.setLayout(new GridLayout(2,2,10,10));
	frame.add(new BarChart().getChartPanel());           //添加柱形图//添加柱形图的另一种效果
	frame.add(new com.njue.testJFreeChart.PieChart().getChartPanel());           //添加饼状图
	frame.add(new com.njue.testJFreeChart.TimeSeriesChart().getChartPanel());    //添加折线图
	frame.setBounds(50, 50, 800, 800);
	frame.setVisible(true);
}
}
