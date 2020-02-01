import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/Add")
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String[] hobbys = request.getParameterValues("hobby");
        String info = request.getParameter("info");
        StudentService service = new StudentServiceImpl();
        String hobby = Arrays.toString(hobbys);
        hobby = hobby.substring(1,hobby.length()-1);

        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setPhone(phone);
        student.setBirthday(birthday);
        student.setHobby(hobby);
        student.setInfo(info);

        try {
            service.Insert(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("StudentList");





    }
}
