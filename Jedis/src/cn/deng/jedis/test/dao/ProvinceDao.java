package cn.deng.jedis.test.dao;

import cn.deng.jedis.test.domain.Province;
import java.util.List;

public interface ProvinceDao {


    public List<Province> findAll();
}
