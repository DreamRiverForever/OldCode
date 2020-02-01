import java.io.*;

public class Test {
    public static String test(String input) {
        String info = null;
        String command = "cmd /c start /b C:\\Users\\dell\\Desktop\\a.exe";
        Runtime runtime = Runtime.getRuntime();
        try{
            Process process = runtime.exec(command);
            process.waitFor();

            Thread.sleep(200);
            BufferedReader br = new BufferedReader(new FileReader("D:\\FlexBison\\3-4\\out.txt"));
            info = br.readLine();
            String flag = br.readLine();
            while (flag.length() != 0){
                info = flag;
                flag = br.readLine();
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return info;


    }
}
