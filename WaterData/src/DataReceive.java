import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DataReceive")
public class DataReceive extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Jdbc jdbc = new Jdbc();
            List<Info> list = jdbc.receiveData();
            jdbc.receiveData3();
            List<StudentInfo> list1 = Cal.averge("demo");
            request.setAttribute("info",list1.get(0));
            request.setAttribute("info2",list1.get(1));
            request.setAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
