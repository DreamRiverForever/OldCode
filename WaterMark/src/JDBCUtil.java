import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static String driverClass = null;
    static String url = null;
    static String name = null;
    static  String password = null;

    static {
        try {
            //读取配置文件
            Properties properties = new Properties();
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //InputStream is = new FileInputStream("jdbc.properties");文件放在根目录下
            properties.load(is);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            name = properties.getProperty("name");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection connection = null;
        try {
            Class.forName(driverClass);
            connection =  DriverManager.getConnection(url,name,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //DriverManager.registerDriver(new Driver());
        //建立连接,注意后面指定编码格式，不然报错

        return connection;
    }


    private static void closeResultSet(ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            resultSet = null;
        }
    }
    private static void closeStatement(Statement statement){
        try {
            if (statement != null){
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            statement = null;
        }
    }
    private static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection = null;
        }
    }
    public static void release(ResultSet resultSet,Statement statement,Connection connection){
        closeConnection(connection);
        closeResultSet(resultSet);
        closeStatement(statement);
    }
}
