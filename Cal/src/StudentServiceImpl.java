import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Info> findAll() throws Exception {
        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    @Override
    public void Insert(Info info) throws Exception {
        StudentDao dao = new StudentDaoImpl();
        dao.Insert(info);

    }
}
