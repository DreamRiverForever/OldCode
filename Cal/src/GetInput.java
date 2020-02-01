import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/GetInput")
public class GetInput extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileOutputStream fos = new FileOutputStream("D:\\FlexBison\\3-4\\in.txt");
        String input = request.getParameter("eval");
        input = input+";\n";

        fos.write(input.toString().getBytes());
        Map<String,String> map = (Map<String,String>)request.getSession().getAttribute("result");
        if (map == null){
            map = new LinkedHashMap();
        }
        String info = Test.test(input);
        map.put(input,info);
        request.getSession().setAttribute("result",map);
        Info info1 = new Info(input,info,new Date());
        StudentService service = new StudentServiceImpl();
        try {
            service.Insert(info1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
        fos.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
