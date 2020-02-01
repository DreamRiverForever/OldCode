import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BMi {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("ceshi.txt"));//读入测试数据
        String line;
        String[] arr = new String[3];
        double high;
        double weight;
        double BMI;
        int[] count = new int[5];
        int num = 0;
        while ((line=br.readLine())!=null&&num<10000){//读入10000条数据
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
            else if (BMI>25&&BMI<30)
                count[3]++;
            else
                count[4]++;
            num++;
        }
        br.close();
        for (int i=0;i<5;i++){
            System.out.println(count[i]);
        }
    }

    public static double bmi(double high,double weight){
        return 703*weight/(high*high);

    }
}
