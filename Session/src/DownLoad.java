import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/DownLoad")
public class DownLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        Map<String,Integer> map = (Map<String,Integer>)request.getSession().getAttribute("car");
        System.out.println(id);
        if (map == null){
            map = new LinkedHashMap();
            request.getSession().setAttribute("car",map);
        }

        map.put(id,map.containsKey(id)?map.get(id)+1:1);
        request.getSession().setAttribute("car",map);


        response.getWriter().write("<a href='index.jsp'><h3>继续购物</h3></a><br>");
        response.getWriter().write("<a href='cart.jsp'><h3>去购物车结算</h3></a>");

    }
}
