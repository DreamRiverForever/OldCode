import javax.crypto.Cipher;  
import javax.crypto.SecretKey;  
import javax.crypto.SecretKeyFactory;  
import javax.crypto.spec.DESKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.security.SecureRandom;
import java.util.Arrays;

public class DEStest {

    //测试
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("demo"));
        String line;
        String password = "cumt1909";
        int sum = 0;
        String str;
        byte[] result;
        int[] arr = new int[20000];
        int k=0;
        String[] a = new String[3];
        //密码，长度要是8的倍数
        while ((line=br.readLine())!=null&&k<20000){
            sum = 0;
            a = line.split("\\s+");
            str = a[0]+Math.floor(Double.parseDouble(a[1]));
            //System.out.println(str);
            //System.out.println(str);
            //System.out.println(str);
            result = DES.encrypt(str.getBytes(),password);
            //System.out.print(result.length+" ");
            for (int i=0;i<result.length;i++){
                //System.out.print(result[i]+" ");
                if (result[i]>0){
                    sum = sum+result[i]*2;
                }else
                    sum = sum-result[i]*3;
            }
           // System.out.println();

            arr[k++] = sum%1296;

        }
        br.close();
        //Arrays.sort(arr);

        int[] flag = new int[1296];
        for (int i=0;i<arr.length;i++){
            flag[arr[i]]++;
        }
        for (int i=0;i<flag.length;i++){
            System.out.print(flag[i]+" ");
            if (i%20==0)
                System.out.println();
        }
        System.out.println();


        //待加密内容






        //直接将如上内容解密
       /* try {
            byte[] decryResult = DES.decrypt(result, password);
            System.out.println("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }*/
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
    public static int containOne(String s){

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

}