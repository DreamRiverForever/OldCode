import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class JsonDataAn {
    public Map<String,String> receivedata(String filename) throws Exception{
        Map<String,String> map = new HashMap();

        BufferedReader br = new BufferedReader(new FileReader(filename));//读入测试数据
        String line;
        String[] arr = new String[3];
        double high;
        double weight;
        double BMI;
        int[] count = new int[5];
        int[] count1 = new int[8];
        int num = 0;
        while ((line=br.readLine())!=null){//读入10000条数据
            num++;
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

        //System.out.println(count1[0]+" "+count1[1]+" "+count1[2]+" "+count1[3]+" "+count1[4]+" "+count1[5]+" "+count1[6]+" "+count1[7]);
        br.close();
        map.put("65",String.valueOf(count1[0]));
        map.put("66",String.valueOf(count1[1]));
        map.put("67",String.valueOf(count1[2]));
        map.put("68",String.valueOf(count1[3]));
        map.put("69",String.valueOf(count1[4]));
        map.put("70",String.valueOf(count1[5]));
        map.put("71",String.valueOf(count1[6]));
        map.put("72",String.valueOf(count1[7]));
       // , , , ,
        map.put("UnderWeight",String.valueOf(count[0]));
        map.put("Thin",String.valueOf(count[1]));
        map.put("Healthy",String.valueOf(count[2]));
        map.put("OverWeight",String.valueOf(count[3]));
        map.put("Obese",String.valueOf(count[4]));
        map.put("length",String.valueOf(num));
        return  map;
    }
    public static double bmi(double high,double weight){
        return 703*weight/(high*high);

    }
}
