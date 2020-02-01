import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = null;
        int id = Integer.parseInt(request.getParameter("id"));
        StudentService service = new StudentServiceImpl();
        try {
            student = service.findStudentByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("student",student);
        request.getRequestDispatcher("update.jsp").forward(request,response);


    }
}
