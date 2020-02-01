package Survey;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;

import java.io.BufferedReader;
import java.io.FileReader;

public class BMIData {
    public static CategoryDataset DataSet() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("demo"));//读入测试数据
        String line;
        String[] arr = new String[3];
        double high;
        double weight;
        double BMI;
        int[] count = new int[5];
        int[] count1 = new int[8];
        while ((line=br.readLine())!=null){//读入10000条数据
            arr = line.split("\\s+");//空格分隔为字符串数组
            high = Double.parseDouble(arr[1]);
            weight = Double.parseDouble(arr[2]);
            if (high<=65){
                count1[0]++;
            }else if(high>65&&high<=66){
                count1[1]++;
            }else if (high>66&&high<=67)
                count1[2]++;
            else if (high>67&&high<=68)
                count1[3]++;
            else if (high>67&&high<=68)
                count1[3]++;
            else if (high>68&&high<=69)
                count1[4]++;
            else if (high>69&&high<=70)
                count1[5]++;
            else if (high>70&&high<=71)
                count1[6]++;
            else
                count1[7]++;

            BMI = bmi(high,weight);
            if (BMI<=18){
                count[0]++;
            }else if(BMI>18&&BMI<=18.5){
                count[1]++;
            }else if (BMI>18.5&&BMI<=25)
                count[2]++;
            else if (BMI>25&&BMI<=30)
                count[3]++;
            else
                count[4]++;
        }

        System.out.println(count1[0]+" "+count1[1]+" "+count1[2]+" "+count1[3]+" "+count1[4]+" "+count1[5]+" "+count1[6]+" "+count1[7]);
        br.close();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Double.valueOf(count[0]), "1", "underweight");
        dataset.addValue(Double.valueOf(count[1]), "2", "thin");
        dataset.addValue(Double.valueOf(count[2]), "3", "healthy");
        dataset.addValue(Double.valueOf(count[3]), "4", "overweight");
        dataset.addValue(Double.valueOf(count[4]), "5", "obese");
        return dataset;
    }

    public static double bmi(double high,double weight){
        return 703*weight/(high*high);

    }

    public static DefaultPieDataset DataSet2() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("demo"));//读入测试数据
        String line;
        String[] arr = new String[3];
        double high;
        double weight;
        double BMI;
        int[] count = new int[5];
        //int num = 0;
        while ((line=br.readLine())!=null){//读入20000条数据
            arr = line.split("\\s+");//空格分隔为字符串数组
            high = Double.parseDouble(arr[1]);
            weight = Double.parseDouble(arr[2]);
            BMI = bmi(high,weight);
            if (BMI<=18){
                count[0]++;
            }else if(BMI>18&&BMI<=18.5){
                count[1]++;
            }else if (BMI>18.5&&BMI<=25)
                count[2]++;
            else if (BMI>25&&BMI<=30)
                count[3]++;
            else
                count[4]++;
        }

        br.close();

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("underweight",count[0]);
        dataset.setValue("thin",count[1]);
        dataset.setValue("healthy",count[2]);
        dataset.setValue("overweight",count[3]);
        dataset.setValue("obese",count[4]);
        return dataset;
    }

    public static DefaultXYDataset DataSet3() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("demo"));//读入测试数据
        String line;
        String[] arr = new String[3];
        double high;
        double weight;
        double BMI;
        int[] count = new int[5];
        double[][] data= new double[2][1000];
        int num = 0;
        while ((line=br.readLine())!=null){//读入10000条数据
            arr = line.split("\\s+");//空格分隔为字符串数组
            high = Double.parseDouble(arr[1]);
            weight = Double.parseDouble(arr[2]);
            data[0][num] = high/50;
            data[1][num] = weight/50;

        }

        br.close();

        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("原始数据",data);

        return dataset;
    }
}
