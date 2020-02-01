import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/ExtractWaterServlet")
public class ExtractWaterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String len = request.getParameter("len");
        String password = request.getParameter("password");

        ExtractWater extractWater = new ExtractWater();
        System.out.println(len+" "+password);

        try {
            Jdbc jdbc = new Jdbc();
            jdbc.receiveData4();
            String str = extractWater.receiveData(password,Integer.parseInt(len));
            System.out.println(str);
            request.setAttribute("username",str);



        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("extractwater.jsp").forward(request,response);
    }
}
