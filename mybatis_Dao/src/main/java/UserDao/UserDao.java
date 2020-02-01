package UserDao;

import domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
    void saveUser(User user);//保存用户信息
    void upData(User uSer);//更新用户信息
    void deletUser(int id);//删除用户信息
    User selectUser(int id);//查询用户信息
    List<User> selectByName(String name);
    int countAll();
}
