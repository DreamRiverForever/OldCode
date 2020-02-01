import java.util.List;

public interface StudentDao {
    List<PeopleInfo> findAll() throws Exception;
    void Insert(PeopleInfo info) throws Exception;


}
