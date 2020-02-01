import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("name= "+name+"   password=  "+password);
        PrintWriter pw = response.getWriter();
        if ("13092325335".equals(name)&&"wqwqw".equals(password)){

            Object object = getServletContext().getAttribute("count");
            int oldCount = 0;
            if (object != null){
                oldCount = (int)object;
            }
            System.out.println("登录次数"+oldCount);
            getServletContext().setAttribute("count",oldCount+1);
            //重新定位状态码
            response.setHeader("location","loginSucces.html");
            response.setStatus(302);
        }else {
            pw.write("faild");
        }
    }
}
