import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String realname = "13092325335";
        String realpassword = "wqwqw";
        if (name.equals(realname) && password.equals(realpassword)){

            Cookie[] cookies = request.getCookies();

            Cookie cookie = CookieUtil.findCookie(cookies,"last");
            System.out.println(cookie);

            if (cookie == null){
                response.addCookie(new Cookie("last",System.currentTimeMillis()+""));
                response.getWriter().write("hello");
            }else {
                Long lasttime = Long.parseLong(cookie.getValue());
                response.getWriter().write("hello "+name+" ,上次来访时间"+new Date(lasttime));
                cookie.setValue(System.currentTimeMillis()+"");
                response.addCookie(cookie);
            }
        }else {
            response.getWriter().write("登录失败");
        }
    }
}
