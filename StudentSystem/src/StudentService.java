import java.util.List;

public interface StudentService {
    List<Student> findAll() throws Exception;
    void Insert(Student student) throws Exception;
    void delete(int id) throws Exception;
    Student findStudentByID(int id) throws Exception;
    void updata(Student student) throws Exception;
    List<Student> searchStudent(String name,String gender) throws Exception;
    PageStudent findStudentByPage(int currentPage) throws Exception;
}
