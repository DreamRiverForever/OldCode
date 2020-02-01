import java.util.List;

public interface StudentDao {
    int PAGE_SIZE = 5;
    List<Student> findAll() throws Exception;
    void Insert(Student student) throws Exception;
    void delete(int id) throws Exception;
    Student findStudentByID(int id) throws Exception;
    void updata(Student student) throws Exception;
    List<Student> searchStudent(String name,String gender) throws Exception;

    //查询单页数据
    List<Student> findStudentByPage(int currentPage) throws Exception;
    int findCount() throws Exception;

}
