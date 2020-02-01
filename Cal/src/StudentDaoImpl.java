import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl  implements StudentDao {

    @Override
    public List<Info> findAll() throws Exception{
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from resultinfo";
        List<Info> list = runner.query(sql,new BeanListHandler<Info>(Info.class));
        return list;
    }

    @Override
    public void Insert(Info info) throws Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "insert into resultinfo values(null,?,?,?)";
        runner.update(sql,
                info.getOp(),
                info.getResult(),
                info.getDate());
    }
}
