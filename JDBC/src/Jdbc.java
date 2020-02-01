
import java.io.*;
import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //注册驱动
        connection = JDBCUtil.getConn();

        //创建statement,一定要这个对象
        String s = "insert into result_copy(id,high,weight) values(?,?,?)";
        statement = connection.prepareStatement(s);
        connection.setAutoCommit(false);
        BufferedReader br = null;//读入测试数据
        try {
            br = new BufferedReader(new FileReader("demo"));
            String line;
            String sql;
            String[] arr = new String[3];
            int count = 0;
            while ((line=br.readLine())!=null){//读入10000条数据

                arr = line.split("\\s+");//空格分隔为字符串数组
                statement.setInt(1, Integer.parseInt(arr[0]));
                statement.setString(2,arr[1]);
                statement.setString(3,arr[2]);
                statement.addBatch();
                count++;
                if (count%100==0)
                {
                    statement.executeBatch();
                    statement.clearBatch();
                    connection.commit();
                }

                System.out.println(count);
            }
            statement.executeBatch();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,statement,connection);
        }

    }


}
