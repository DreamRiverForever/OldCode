import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentlistPage")
public class StudentlistPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("currentPage"));
        StudentService service = new StudentServiceImpl();
        try {
            PageStudent pageStudent = service.findStudentByPage(page);
            request.setAttribute("pageStudent",pageStudent);
            request.getRequestDispatcher("listPage.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
