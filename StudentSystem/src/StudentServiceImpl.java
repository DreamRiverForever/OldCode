import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws Exception {
        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    @Override
    public void delete(int id) throws Exception {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(id);
    }

    @Override
    public void Insert(Student student) throws Exception{
        StudentDao dao = new StudentDaoImpl();
        dao.Insert(student);

    }

    @Override
    public Student findStudentByID(int id) throws Exception {
        StudentDao dao = new StudentDaoImpl();
        return dao.findStudentByID(id);
    }

    @Override
    public void updata(Student student) throws Exception {
        StudentDao dao = new StudentDaoImpl();
        dao.updata(student);
    }

    @Override
    public List<Student> searchStudent(String name, String gender) throws Exception {
        StudentDao dao = new StudentDaoImpl();
        return dao.searchStudent(name,gender);
    }

    @Override
    public PageStudent findStudentByPage(int currentPage) throws Exception {
        PageStudent pageStudent = new PageStudent();
        StudentDao dao = new StudentDaoImpl();
        int count =dao.findCount();
        int pageLen = StudentDao.PAGE_SIZE;
        pageStudent.setCurrentPage(currentPage);
        pageStudent.setPageSize(pageLen);
        pageStudent.setList(dao.findStudentByPage(currentPage));
        pageStudent.setTotalPage(count%pageLen==0?count/pageLen:count/pageLen+1);//总页数
        pageStudent.setTotalSize(count);//总记录数
        return pageStudent;
    }
}
