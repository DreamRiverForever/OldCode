import java.util.List;

public interface StudentDao {
    List<Info> findAll() throws Exception;
    void Insert(Info info) throws Exception;


}
