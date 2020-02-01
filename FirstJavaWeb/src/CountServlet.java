import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument;
import java.io.IOException;

@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //修改中文字符编码
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html; charset=UTF-8");
        int count = (int)getServletContext().getAttribute("count");
        //写出中文乱码？？？？？
        response.getWriter().write("登录次数是"+count);

    }
}
