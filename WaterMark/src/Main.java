import Survey.BarChart;
import Survey.OverlaidDrawLineScatter;
import Survey.PieChart;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;


import javax.swing.*;

public class Main extends JFrame implements ActionListener{
    //JSplitPane JSP;
    JTextArea jta1,jta2;
    JMenuBar jmb;
    JMenu jm2,jm3,jm4;
    JMenuItem jmi3,jmi4,jmi5,jmi32,jmi33,jmi34;
    JScrollPane jsp,jsp2,jsp1;
    //JSplitPane js;

    JPanel jp1,jp2,jp3,jp4,jta;
    JLabel j1b1,jlb2;
    JTextField jtf1;
    JButton jb1;
    JPasswordField jpf1;




    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main demo=new Main();

    }
    public Main() {

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();
        j1b1=new JLabel("水印信息 ");
        jlb2=new JLabel("密钥 ");
        jtf1=new JTextField(20);
        jtf1.setFont(new Font("宋体",Font.BOLD,17) );
        jpf1=new JPasswordField(16);
        jpf1.setFont(new Font("宋体", Font.PLAIN, 17) );
        //this.setLayout(new GridLayout(1, 3));
        jp1.add(j1b1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jpf1);
        jp4.add(jp1);
        jp4.add(jp2);
        jp4.add(jp3);





        jta=new JPanel();
        jta1=new JTextArea();
        jta1.setFont(new Font("宋体",Font.BOLD,17));
        jta2=new JTextArea();
        jta2.setFont(new Font("楷体",Font.BOLD,23));
        jta2.setEditable(false);




        jmb=new JMenuBar();
        jm2=new JMenu("数据分析");
        jm3=new JMenu("增加水印");
        jm4=new JMenu("提取水印");
        jmi3=new JMenuItem("柱状图");
        jmi4=new JMenuItem("Start");
        jmi5=new JMenuItem("ReciveWater");
        jmi32=new JMenuItem("数据获取");
        jmi33=new JMenuItem("饼状图");
        jmi34=new JMenuItem("线性图");
        //注册监听
        //
        jmi3.addActionListener(this);
        jmi3.setActionCommand("run");

        jmi32.addActionListener(this);
        jmi32.setActionCommand("mysql");

        jmi33.addActionListener(this);
        jmi33.setActionCommand("run2");

        jmi34.addActionListener(this);
        jmi34.setActionCommand("run3");

        jmi4.addActionListener(this);
        jmi4.setActionCommand("start");

        jmi5.addActionListener(this);
        jmi5.setActionCommand("water");

        //
        this.setJMenuBar(jmb);
        jmb.add(jm2);
        jm2.add(jmi32);
        jm2.add(jmi3);
        jm2.add(jmi33);
        jm2.add(jmi34);



        jmb.add(jm3);
        jm3.add(jmi4);

        jmb.add(jm4);
        jm4.add(jmi5);

        this.setLayout(new BorderLayout());
        this.add(jta2,BorderLayout.NORTH);
        this.add(jp4,BorderLayout.WEST);
        this.add(jta,BorderLayout.CENTER);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200,700);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        jta.removeAll();
        jta2.setText("");
        // TODO Auto-generated method stub

        if (arg0.getActionCommand().equals("run")) {//数据分析

            jta.add(new BarChart().getChartPanel());
            //jta.add(new BarChart().getChartPanel().setSize(600,200));
            jta.revalidate();

        }else if (arg0.getActionCommand().equals("run2")){
            jta.add(new PieChart().getChartPanel());
            //jta.add(new BarChart().getChartPanel().setSize(600,200));
            jta.revalidate();

        }else if (arg0.getActionCommand().equals("run3")){
            jta.add(new OverlaidDrawLineScatter("线性分析表").getPanel());
            //jta.add(new OverlaidDrawLineScatter().setSize(600,200));
            jta.revalidate();

        }

        if (arg0.getActionCommand().equals("mysql")) {//数据获取
            Jdbc jdbc = new Jdbc();
            try {
                jdbc.receiveData();
                jta2.setText("数据获取成功");
            } catch (Exception e) {
                e.printStackTrace();
                jta2.setText("数据获取失败");
            }
        }

        if (arg0.getActionCommand().equals("start")) {//水印添加
            jta2.setText("");
            if (jtf1.getText().equals("")|| String.valueOf(jpf1.getPassword()).equals("")){
                jta2.setText("输入不能为空");
            }else {

                Desdemo desdemo = new Desdemo();
                String waterdata = jtf1.getText();
                System.out.println(waterdata);
                String password =  String.valueOf(jpf1.getPassword());
                try {
                    waterdata = new String(waterdata.getBytes("utf-8"));
                    password = new String(password.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] bytes = null;
                try {
                    bytes = desdemo.ciphertext(waterdata,password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jta2.setText("加密位数 "+bytes.length*9*3+"    "+"密码为 "+password);

                AddWaterData addWaterData = new AddWaterData();
                try {
                    addWaterData.addwater(bytes,password);
                    Jdbc jdbc = new Jdbc();
                    jdbc.deletData();
                    jdbc.insertData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (arg0.getActionCommand().equals("water")) {//水印提取
            jta2.setText("");
            Jdbc jdbc = new Jdbc();
            if (jtf1.getText().equals("")|| String.valueOf(jpf1.getPassword()).equals("")){
                jta2.setText("输入不能为空");
            }else {
                try {
                    jdbc.receiveData2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ExtractWater extractWater = new ExtractWater();
                int codelen = Integer.parseInt(jtf1.getText());
                String password = String.valueOf(jpf1.getPassword());
                System.out.println(codelen+" "+password);
                try {
                    String waterData = extractWater.receiveData(password, codelen);
                    System.out.println(waterData);
                    jta2.setText("数据源拥有者为   " + waterData);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
