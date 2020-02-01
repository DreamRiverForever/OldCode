import java.util.List;

public interface StudentService {
    List<Info> findAll() throws Exception;
    void Insert(Info info) throws Exception;

}
