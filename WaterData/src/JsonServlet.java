import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map<String,String> map = null;
            Jdbc jdbc = new Jdbc();
            jdbc.receiveData3();
            JsonDataAn dataAn = new JsonDataAn();
            map = dataAn.receivedata("demo");
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSON(map));
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
