import java.io.BufferedReader;
import java.io.FileReader;

public class ExtractWater {//提取水印
    public String receiveData(String password,int codelen) throws Exception{
        //开始提取水印数据
        char[] chars = new char[codelen];
        for (int i=0;i<codelen;i++){
            chars[i] = '0';
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("result"));//从添加水印信息result文件中抽取子集存入samlldata中，在子集中提取水印
        String line;
        String[] arr = new String[3];
        String str;
        byte[] result ;
        int index;
        int index2;
        while ((line=bufferedReader.readLine())!=null){
            arr = line.split("\\s+");
            if (arr[1].length()>7){
                str = arr[0]+Math.floor(Double.parseDouble(arr[1]));
                result = DES.encrypt(str.getBytes(),password);//获取数据元组对应的hash
                index = index(result,codelen);//获取所存数据在码原即code中的位置
                index2 = index(arr[1],result);
                int num = Integer.parseInt(String.valueOf(arr[1].charAt(index2)));//获取最后一位数字
                if (num%2==0)//按照一定规则获取水印的位信息
                    chars[index] = '0';//按照index下标还原code
                else
                    chars[index] = '1';

                str = arr[0]+Math.floor(Double.parseDouble(arr[2]));
                result = DES.encrypt(str.getBytes(),password);//获取数据元组对应的hash
                index = index(result,codelen);//获取所存数据在码原即code中的位置
                index2 = index(arr[2],result);
                num = Integer.parseInt(String.valueOf(arr[2].charAt(index2)));//获取最后一位数字
                if (num%2==0)//按照一定规则获取水印的位信息
                    chars[index] = '0';//按照index下标还原code
                else
                    chars[index] = '1';

            }
        }
        bufferedReader.close();
        String tar = "";//char数组存入String
        for (int i=0;i<chars.length;i++){
            tar+=chars[i];
            System.out.print(chars[i]);
        }
        System.out.println();
        System.out.println(tar.length());
        String mayuan = "";
        String temp;
        int m;
        int n;
        int bound = tar.length()/3;
        for (int i=0;i<bound;i++){//去除重复码
            m=n=0;
            temp = tar.substring(0,3);
            for (int j=0;j<3;j++){
                if (temp.charAt(j)=='1')//大数判别
                    m++;
                else
                    n++;
            }
            if (m>n){
                mayuan+="1";
            }else
                mayuan+="0";
            tar = tar.substring(3,tar.length());
        }
        System.out.println(mayuan);
        System.out.println(mayuan.length());
        int len = mayuan.length()/9;
        int c;
        byte[] bytes = new byte[len];//用于存储提取的水印信息，并负责解密
        for (int i=0;i<len;i++){//去除校验码
            temp = mayuan.substring(0,8);
            //System.out.println(temp+" "+Integer.valueOf(temp,2)+" ");
            c = Integer.valueOf(temp,2);//每八位字符串按二进制转化为十进制
            bytes[i] = (byte)(c & 0xff);//int是4字节，转byte只需要后8位
            System.out.print(bytes[i]+" ");
            mayuan = mayuan.substring(9,mayuan.length());
        }
        byte[] decryResult = DES.decrypt(bytes, password);
        if (decryResult == null)
            return "水印提取失败";
        else
            return new String(decryResult);
    }

    public static int index(byte[] result,int codelen){//按照hashcode匹配下标
        int sum = 0;
        for (int i=0;i<result.length;i++){
            if (result[i]>0){
                sum+=result[i]*2;
            }else
                sum-=result[i]*3;
        }
        return sum%codelen;
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
