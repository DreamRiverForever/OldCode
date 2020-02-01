import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class StudentDaoImpl  implements StudentDao {

    @Override
    public List<PeopleInfo> findAll() throws Exception{
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from resultinfo";
        List<PeopleInfo> list = runner.query(sql,new BeanListHandler<PeopleInfo>(PeopleInfo.class));
        return list;
    }

    @Override
    public void Insert(PeopleInfo info) throws Exception {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "insert into demo values(null,?,?)";
        runner.update(sql,
                info.getHigh(),
                info.getWeight());
    }
}
