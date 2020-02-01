import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/DownLoadFile")
public class DownLoadFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getParameter("filename");


        String path = getServletContext().getRealPath("download/"+filename);
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        System.out.println(filename);
        InputStream is = new FileInputStream(path);

        OutputStream os = response.getOutputStream();
        System.out.println("建立连接");
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        os.close();
        is.close();


    }
}
