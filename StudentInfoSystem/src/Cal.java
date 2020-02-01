import java.awt.*;

public class Cal {
    // 本地方法声明
      native void calcpar(String FileIn , String FileOut);

      static{ System.loadLibrary("libmycalc"); }
      public static void main(String args[])
      {
          Cal myJNI = new Cal();
          myJNI.calcpar("in.txt","out.txt");
      }

}
