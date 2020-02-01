import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Cal {
    public static List<StudentInfo> averge(String filename){
        StudentInfo info = new StudentInfo();
        StudentInfo info1 = new StudentInfo();
        List<StudentInfo> list = new LinkedList<StudentInfo>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));//读入测试数据
            String line;
            String[] arr = new String[3];
            double high;
            double weight;
            double sum = 0;
            double sum1 = 0;
            int count = 0;
            int count1 = 0;
            int k = 0;
            while ((line=br.readLine())!=null){//读入10000条数据
                arr = line.split("\\s+");//空格分隔为字符串数组
                high = Double.parseDouble(arr[1]);
                weight = Double.parseDouble(arr[2]);
                //System.out.println(high+" "+weight);
                sum+=high;
                sum1+=weight;
                if (high*0.0254>1.66&&high*0.0254<1.78)
                    count++;
                if (weight*0.453>57&&high*0.453<65)
                    count1++;
                k++;
            }
            br.close();
            double ave = sum/k;
            double ave2 = sum1/k;
            String s1 = String.format("%.2f", ave);
            ave = Double.valueOf(s1);
            String s2 = String.format("%.2f", ave2);
            ave2 = Double.valueOf(s2);
            info.setAverge(ave);
            info1.setAverge(ave2);
            //System.out.println(count+" "+count1+" "+k);


            s1 = String.format("%.2f", (double)count/k);
            info.setRate(Double.valueOf(s1));

            s2 = String.format("%.2f",(double)count1/k);

            info1.setRate(Double.valueOf(s2));

            sum = sum1 = 0;
            BufferedReader br1 = new BufferedReader(new FileReader(filename));//读入测试数据
            while ((line=br1.readLine())!=null){
                arr = line.split("\\s+");//空格分隔为字符串数组
                high = Double.parseDouble(arr[1]);
                weight = Double.parseDouble(arr[2]);
                sum += (high - ave)*(high - ave);
                sum1 += (weight - ave2)*(weight - ave2);
            }
            br1.close();
            s1 = String.format("%.4f", sum/k);

            s2 = String.format("%.4f",sum1/k);

            info.setVariance(Double.valueOf(s1));
            info1.setVariance(Double.valueOf(s2));
            list.add(info);
            list.add(info1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
