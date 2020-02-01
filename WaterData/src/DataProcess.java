import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/DataProcess")
public class DataProcess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        System.out.println("name= "+name+"   password=  "+password);
        Desdemo desdemo = new Desdemo();
        try {
            byte[] bytes = desdemo.ciphertext(name,password);
            System.out.println("这是加密过后");
            for (int i=0;i<bytes.length;i++){
                System.out.print(bytes[i]+" ");
            }
            System.out.println();

            request.setAttribute("length",bytes.length*9*3);
            request.setAttribute("password",password);
            AddWaterData addWaterData = new AddWaterData();
            addWaterData.addwater(bytes,password);
            Jdbc jdbc = new Jdbc();
            jdbc.deletData();
            jdbc.insertData();
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("addwater.jsp").forward(request,response);
    }
}
