import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/JsonServlet2")
public class JsonServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map<String,String> map = null;
            Jdbc jdbc = new Jdbc();
            jdbc.receiveData4();
            JsonDataAn dataAn = new JsonDataAn();
            map = dataAn.receivedata("result");
            List<StudentInfo> list1 = Cal.averge("demo");
            List<StudentInfo> list2 = Cal.averge("result");
            map.put("avg1",String.valueOf(list1.get(0).getAverge()));
            map.put("variance1",String.valueOf(list1.get(0).getVariance()));
            map.put("rate1",String.valueOf(list1.get(0).getRate()));
            map.put("avg2",String.valueOf(list1.get(1).getAverge()));
            map.put("variance2",String.valueOf(list1.get(1).getVariance()));
            map.put("rate2",String.valueOf(list1.get(1).getRate()));

            map.put("avg3",String.valueOf(list2.get(0).getAverge()));
            map.put("variance3",String.valueOf(list2.get(0).getVariance()));
            map.put("rate3",String.valueOf(list2.get(0).getRate()));
            map.put("avg4",String.valueOf(list2.get(1).getAverge()));
            map.put("variance4",String.valueOf(list2.get(1).getVariance()));
            map.put("rate4",String.valueOf(list2.get(1).getRate()));
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSON(map));
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
