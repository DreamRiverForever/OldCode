import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("ceshi.txt"));
        String line;
        String[] arr = new String[3];
        StudentService service = new StudentServiceImpl();
        PeopleInfo info;
        while ((line=br.readLine())!=null){
           arr = line.split("\\s+");
           double high = Double.parseDouble(arr[1]);
           double weight = Double.parseDouble(arr[2]);
           info = new PeopleInfo(high,weight);
            try {
                service.Insert(info);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        br.close();
    }
}
