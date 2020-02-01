import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/Update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id")) ;
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String[] hobbys = request.getParameterValues("hobby");
        String info = request.getParameter("info");

        String hobby = Arrays.toString(hobbys);
        hobby = hobby.substring(1,hobby.length()-1);

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setGender(gender);
        student.setPhone(phone);
        student.setBirthday(birthday);
        student.setHobby(hobby);
        student.setInfo(info);
        StudentService service = new StudentServiceImpl();
        try {
            service.updata(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("StudentList").forward(request,response);


    }
}
