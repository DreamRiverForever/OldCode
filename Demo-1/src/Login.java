import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String realname = "13092325335";
        String realpassword = "wqwqw";
        System.out.println(realname+realpassword+name+password);
        if (name.equals(realname) && password.equals(realpassword)){
            //早期写法
           /* response.setHeader("location","download.html");
            response.setStatus(302);*/

           //重定向
           /* response.sendRedirect("download.html");*/

            //请求转发
            request.getRequestDispatcher("download.html").forward(request,response);


        }else {
            response.getWriter().write("登录失败");
        }

    }
}
