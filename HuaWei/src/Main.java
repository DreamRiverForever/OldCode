import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int page = sc.nextInt();
        String str;
        String[] s = new String[2];

        HashMap<String,String> map = new HashMap<>();
        for (int i=page;i>1;i--){
            str = sc.next();
            s =  str.split("=");
            map.put(s[0],s[1]);
        }
        for (String string:map.keySet()
             ) {
            if (map.get(string))
        }
        str = sc.next();
        s = str.split("=");
        str = s[1];




    }
    public void count(Map map,String string){



    }
}
