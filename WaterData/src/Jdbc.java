import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Jdbc {
    public List<Info> receiveData() throws Exception{//获取没加水印的信息
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Info> list = null;
        //注册驱动
        try {
            connection = JDBCUtil.getConn();

            //创建statement,一定要这个对象
            statement = connection.createStatement();

            //执行sql语句，得到结果
            statement.executeQuery("select * from demo");
            resultSet = statement.getResultSet();
            //遍历结果得到数据
            list = print(resultSet);
            //返回影响的函数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,statement,connection);
        }
        return list;

    }

    public  List<Info> receiveData2() throws Exception{//数据库获取加了水印的数据
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Info> list = null;
        //注册驱动
        try {
            connection = JDBCUtil.getConn();

            //创建statement,一定要这个对象
            statement = connection.createStatement();

            //执行sql语句，得到结果
            statement.executeQuery("select * from result");
            resultSet = statement.getResultSet();
            //遍历结果得到数据
            list = print(resultSet);
            //返回影响的函数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,statement,connection);
        }
        return list;

    }


    public static List print(ResultSet resultSet){
        List<Info> list = null;
            try {
                int count = 0;
                list = new LinkedList<Info>();
                while (resultSet.next()&&count<500){
                    Info info = new Info(resultSet.getInt("id"),resultSet.getDouble("high"),resultSet.getDouble("weight"),new Date());
                    list.add(info);
                    count++;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        return list;
    }

    public  void receiveData3() throws Exception{//获取没加水印的信息写入文件
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //注册驱动
        try {
            connection = JDBCUtil.getConn();

            //创建statement,一定要这个对象
            statement = connection.createStatement();

            //执行sql语句，得到结果
            statement.executeQuery("select * from demo");
            resultSet = statement.getResultSet();
            //遍历结果得到数据
            print1(resultSet,"demo");
            //返回影响的函数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,statement,connection);
        }

    }

    public  void receiveData4() throws Exception{//数据库获取加了水印的数据写入文件
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //注册驱动
        try {
            connection = JDBCUtil.getConn();

            //创建statement,一定要这个对象
            statement = connection.createStatement();

            //执行sql语句，得到结果
            statement.executeQuery("select * from result");
            resultSet = statement.getResultSet();
            //遍历结果得到数据
            print1(resultSet,"result");
            //返回影响的函数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,statement,connection);
        }

    }

    public static void print1(ResultSet resultSet,String filename){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            while (resultSet.next()){
                bw.write(resultSet.getInt("id")+" "+resultSet.getDouble("high")+" "+resultSet.getDouble("weight")+"\n");
            }
            bw.close();
            //System.out.println("写入文件了");
            //File file = new File("result");
            //System.out.println(file.getAbsolutePath());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void insertData() throws Exception{

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //注册驱动
        connection = JDBCUtil.getConn();

        //创建statement,一定要这个对象
        String s = "insert into result(id,high,weight) values(?,?,?)";
        connection.setAutoCommit(false);
        statement = connection.prepareStatement(s);


        BufferedReader br = null;//读入测试数据
        try {
            br = new BufferedReader(new FileReader("result"));
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
                if (count%1000==0)
                {
                    statement.executeBatch();
                    statement.clearBatch();
                    connection.commit();
                }
                count++;
            }
            statement.executeBatch();
            connection.commit();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,statement,connection);
        }

    }

    public static void deletData() throws Exception{

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //注册驱动
        try {
            connection = JDBCUtil.getConn();

            //创建statement,一定要这个对象
            statement = connection.createStatement();

            //执行sql语句，得到结果
            statement.execute(" delete from result where id>0");
            //返回影响的函数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,statement,connection);
        }
    }

}
