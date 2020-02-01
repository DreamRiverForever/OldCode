import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/WaterDataReceive")
public class WaterDataReceive extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Jdbc jdbc = new Jdbc();
            List<Info> list = jdbc.receiveData2();
            jdbc.receiveData4();
            List<StudentInfo> list1 = Cal.averge("result");
            request.setAttribute("info3",list1.get(0));
            request.setAttribute("info4",list1.get(1));
            request.setAttribute("list2",list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("dashboard2.jsp").forward(request,response);

    }
}
