import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.management.Query;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StudentDaoImpl  implements StudentDao{

    @Override
    public List<Student> findAll() throws Exception{
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stuinfo";
        List<Student> list = runner.query(sql,new BeanListHandler<Student>(Student.class));
        return list;
    }

    @Override
    public void delete(int id) throws Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "delete from stuinfo where id=?";
        runner.update(sql,id);
    }

    @Override
    public List<Student> findStudentByPage(int currentPage) throws Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stuinfo limit ? offset ?";
        return runner.query(sql,new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
    }

    @Override
    public Student findStudentByID(int id) throws Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stuinfo where id=?";
        return runner.query(sql,new BeanHandler<Student>(Student.class),id);
    }

    @Override
    public void Insert(Student student) throws Exception{
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "insert into stuinfo values(null,?,?,?,?,?,?)";
        runner.update(sql,
                student.getName(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo());
    }

    @Override
    public void updata(Student student) throws Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "update stuinfo set name=?,gender=?,phone=?,birthday=?,hobby=?,info=? where id=?";
        runner.update(sql,
                student.getName(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),student.getId());
    }

    @Override
    public List<Student> searchStudent(String name, String gender)  throws Exception{
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stuinfo where 1=1 ";
        List<String> list = new ArrayList<String>();
        if ( name.length() != 0){
            sql+=" and name like ?";
            list.add("%"+name+"%");
        }
        if ( gender.length() != 0){
            sql+=" and gender = ?";
            list.add(gender);
        }
        return runner.query(sql,new BeanListHandler<Student>(Student.class),list.toArray());

    }

    @Override
    public int findCount() throws Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select COUNT(*) from stuinfo";
        Long result = (Long)runner.query(sql,new ScalarHandler());
        return result.intValue();
    }
}
