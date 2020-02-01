import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<PeopleInfo> findAll() throws Exception {
        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    @Override
    public void Insert(PeopleInfo info) throws Exception {
        StudentDao dao = new StudentDaoImpl();
        dao.Insert(info);

    }
}
