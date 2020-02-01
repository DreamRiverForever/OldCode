package cn.deng.jedis.test.service.impl;

import cn.deng.jedis.test.dao.ProvinceDao;
import cn.deng.jedis.test.dao.impl.ProvinceDaoImpl;
import cn.deng.jedis.test.domain.Province;
import cn.deng.jedis.test.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }
}
