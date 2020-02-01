import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/DownLoad")
public class DownLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getParameter("filename");
        //谷歌浏览器可以不用关心文件名中文，IE要转编码就是如下代码
        //byte[] bs = filename.getBytes("ISO-8859-1");
        //filename = new String(bs,"UTF-8");

        System.out.println(filename);


        String path = getServletContext().getRealPath("download/"+filename);
        filename = URLEncoder.encode(filename,"UTF-8");//这段代码必须在path赋值下面，不然乱码，path找不到路径
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        InputStream is = new FileInputStream(path);
        OutputStream os = response.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1){
            os.write(bytes);
        }
        is.close();
        os.close();



    }
}
