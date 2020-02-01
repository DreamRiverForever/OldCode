import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/History")
public class History extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       StudentService service = new StudentServiceImpl();
        try {
            List<Info> list = service.findAll();
            request.setAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("histroy.jsp").forward(request,response);

    }
}
