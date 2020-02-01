import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AddWaterData {
    public int codelen ;
    public void addwater(byte[] result,String password) throws Exception{

      /*  for (int i=0;i<result.length;i++)
            System.out.print(result[i]+" ");*/
        String code = "";
        String binary = "";
        //用于存放8位二进制数
        for (int i=0;i<result.length;i++){//每八位二进制添加一个差错校验位并合成字符串code
            binary = Integer.toBinaryString(result[i]);
            //System.out.print(result[i]+" ");
            //binary = binary.split(binary.length()-8,binary.length());
            if (binary.length()>8)
                binary = binary.substring(binary.length()-8,binary.length());
            else {
                String head = "";
                for (int j = 0; j < 8 - binary.length(); j++)
                    head+="0";
                binary = head+binary;
            }
            binary+=containOne(binary);
            code+=binary;
        }
        System.out.println(code);
        code = repeat(code,3);//将code重复3次，即011变为000111111
        //System.out.println(code);
        //System.out.println(code.length());
        this.codelen = code.length();



        BufferedReader br = new BufferedReader(new FileReader("demo"));//读入测试数据
        BufferedWriter wr = new BufferedWriter(new FileWriter("result"));//输出加水印后的数据
        String line;
        String[] arr = new String[3];
        int index = 0;
        int index2 = 0;
        String str = "";
        while ((line=br.readLine())!=null){//读入10000条数据
            arr = line.split("\\s+");//空格分隔为字符串数组
            if (arr[1].length()>7){//有效位大于7才可以加水印信息
                str = arr[0]+Math.floor(Double.parseDouble(arr[1]));
                result = DES.encrypt(str.getBytes(),password);//对没有加水印的字段取hash加密
                index = index(result);//通过一定匹配规则定位加入信息在code中的位置
                index2 = index(arr[1],result);
                arr[1] = addWaterMark(arr[1],code.charAt(index),index2);//对二号数据添加信息


                str = arr[0]+Math.floor(Double.parseDouble(arr[2]));
                result = DES.encrypt(str.getBytes(),password);//对没有加水印的字段取hash加密
                index = index(result);//通过一定匹配规则定位加入信息在code中的位置
                index2 = index(arr[2],result);
                arr[2] = addWaterMark(arr[2],code.charAt(index),index2);//对三号数据添加信息
            }
            wr.write(arr[0]+" "+arr[1]+" "+arr[2]+"\n");//写入文件
        }
        br.close();
        wr.close();

    }

    public static int containOne(String s){//增加校验位

        int count = 0;
        int index = 0;
        String s1 = "1";
        while(s.indexOf(s1)!=-1){
            index=s.indexOf(s1) + s1.length();
            s = s.substring(index);
            count++;
        }
        if (count%2==0)
            return 1;
        else
            return 0;
    }

    public static String repeat(String str,int r){//重复码
        String s = "";
        char t ;
        for (int i=0;i<str.length();i++){
            t = str.charAt(i);
            for (int j=0;j<r;j++){
                s+=t;
            }
        }
        return s;

    }

    public int index(byte[] result){//按照hashcode匹配下标
        int sum = 0;
        for (int i=0;i<result.length;i++){
            if (result[i]>0){
                sum+=result[i]*2;
            }else
                sum-=result[i]*3;
        }
        return sum%this.codelen;
    }

    public static String addWaterMark(String str,char a,int index){//添加水印信息
        char b = str.charAt(index);
        int num1 = Integer.parseInt(String.valueOf(b));//X
        int num = Integer.parseInt(String.valueOf(a));//二进制
        if (num == 1 && num1%2==0){
            num1++;
        }
        if (num == 0 && num1%2==1){
            if (num1<9)
                num1+=1;
            else
                num1-=1;
        }

        if (index == str.length()-1){
            str = str.substring(0,index)+num1;
        }
        else {
            str = str.substring(0,index)+num1+str.substring(index+1,str.length());
        }
        return str;
    }
    public static int index(String str,byte[] result){//获取嵌入位置
        String[] s = str.split("\\.");
        int sum = 0;
        for (int i=0;i<result.length;i++){
            if (result[i]>0){
                sum+=result[i]*2;
            }else
                sum-=result[i]*3;
        }
        return sum%s[1].length()+s[0].length()+1;

    }
}
