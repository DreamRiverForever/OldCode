import java.util.List;

public interface StudentService {
    List<PeopleInfo> findAll() throws Exception;
    void Insert(PeopleInfo info) throws Exception;

}
