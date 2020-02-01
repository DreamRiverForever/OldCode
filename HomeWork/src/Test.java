import java.awt.desktop.OpenURIEvent;
import java.io.*;
import java.nio.Buffer;
import java.sql.BatchUpdateException;

public class Test {
    public static void main(String[] args) {

        String command = "cmd /c start /b C:\\Users\\dell\\Desktop\\a.exe";
        Runtime runtime = Runtime.getRuntime();
        try{
            Process process = runtime.exec(command);
            process.waitFor();
            Thread.sleep(500);
            InputStream is = new FileInputStream("D:\\FlexBison\\3-4\\out.txt");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }



        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
