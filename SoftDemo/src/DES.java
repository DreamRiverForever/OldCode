import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
/**
 DES加密介绍
      DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 。
 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */
public class DES {
    protected static String  code = "";
    public  int codelen = 864;
    public DES() {
    }
    //测试
    public static void main(String args[]) throws Exception{
         //待加密内容
         String str = "邓玉文中国矿业大学06162501";
         //密码，长度要是8的倍数
         String password = "06162501";

         byte[] result = DES.encrypt(str.getBytes(),password);
        System.out.println(result.length);
         String binary = "";
         //用于存放8位二进制数
         for (int i=0;i<result.length;i++){//每八位二进制添加一个差错校验位并合成字符串code
             binary = Integer.toBinaryString(result[i]);
             System.out.print(result[i]+" ");
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
         code = repeat(code,3);//将code重复3次，即011变为000111111
        System.out.println(code);
        System.out.println(code.length());



        BufferedReader br = new BufferedReader(new FileReader("ceshi.txt"));//读入测试数据
        BufferedWriter wr = new BufferedWriter(new FileWriter("result"));//输出加水印后的数据
        String line;
        String[] arr = new String[3];
        int index = 0;
        int[] arrs = new int[1080];
        int count = 0;
        while ((line=br.readLine())!=null && count<10000){//读入10000条数据
            arr = line.split("\\s+");//空格分隔为字符串数组
            if (arr[1].length()>7){//有效位大于7才可以加水印信息
                str = arr[0]+arr[2];
                result = DES.encrypt(str.getBytes(),password);//对没有加水印的字段取hash加密
                index = index(result);//通过一定匹配规则定位加入信息在code中的位置
                arrs[index] = 1;

                arr[1] = addWaterMark(arr[1],code.charAt(index));//对二号数据添加信息
            }
            wr.write(arr[0]+" "+arr[1]+" "+arr[2]+"\n");//写入文件
            count++;
        }
        br.close();
        wr.close();
        Arrays.sort(arrs);
        System.out.println("数组元素");
        for (int i=0;i<arrs.length;i++){
            System.out.print(arrs[i]);
        }





        //开始提取水印数据
        char[] chars = new char[1080];
        for (int i=0;i<1080;i++){
            chars[i] = '0';
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("result"));//从添加水印信息result文件中抽取子集存入samlldata中，在子集中提取水印

        while ((line=bufferedReader.readLine())!=null){
            arr = line.split(" ");
            if (arr[1].length()>7){
                str = arr[0]+arr[2];
                result = DES.encrypt(str.getBytes(),password);//获取数据元组对应的hash
                index = index(result);//获取所存数据在码原即code中的位置
                int num = Integer.parseInt(String.valueOf(arr[1].charAt(arr[1].length()-1)));//获取最后一位数字
                if (num%2==0)//按照一定规则获取水印的位信息
                    chars[index] = '0';//按照index下标还原code
                else
                    chars[index] = '1';

            }
        }
        bufferedReader.close();
        String tar = "";//char数组存入String
        for (int i=0;i<chars.length;i++){
            System.out.print(chars[i]);
            tar+=chars[i];
        }
        System.out.println();
        System.out.println(tar.length());
        System.out.println(code.equals(tar));
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


         //直接将如上内容解密
         try {
                 byte[] decryResult = DES.decrypt(bytes, password);
                 System.out.println("解密后："+new String(decryResult,"utf-8"));
         } catch (Exception e1) {
                 e1.printStackTrace();
         }
    }
    /**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    public static  byte[] encrypt(byte[] datasource, String password) {            
        try{
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        //创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        //Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
        //用密匙初始化Cipher对象,ENCRYPT_MODE用于将 Cipher 初始化为加密模式的常量
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
        //现在，获取数据并加密
        //正式执行加密操作
        return cipher.doFinal(datasource); //按单部分操作加密或解密数据，或者结束一个多部分操作
        }catch(Throwable e){
                e.printStackTrace();
        }
        return null;
}
    /**
     * 解密
     * @param src byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String password) throws Exception {
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");//返回实现指定转换的 Cipher 对象
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            return cipher.doFinal(src);
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

    public static String getCode() {
       return code;
    }


    public static int index(byte[] result){//按照hashcode匹配下标
        int sum = 0;
        for (int i=0;i<result.length;i++){
            if (result[i]>0){
                sum+=result[i]*2;
            }else
                sum-=result[i];
        }
        return sum%1080;
    }

    public static String addWaterMark(String str,char a){//添加水印信息
        char b = str.charAt(str.length()-1);
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
        str = str.substring(0,str.length()-1)+num1;
        return str;
    }
}
