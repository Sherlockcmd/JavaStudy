package com.easy.web.service.impl;

import com.easy.web.dao.IBanjiDao;
import com.easy.web.dao.impl.BanjiDaoImpl;
import com.easy.web.pojo.Banji;
import com.easy.web.pojo.vo.BanjiCountVO;
import com.easy.web.service.IBanjiService;
import com.easy.web.util.PageResult;

import java.util.List;

public class BanjiServiceImpl implements IBanjiService {
    private IBanjiDao banjiDao = new BanjiDaoImpl();

    @Override
    public PageResult<Banji> selectByPage(Integer page, Integer limit) {
        int offset = (page - 1) * limit;
        List<Banji> list = banjiDao.selectByPage(offset, limit);
        int totalCount = banjiDao.selectTotalCount();

        return new PageResult<>(0, "", totalCount, list);
    }

    @Override
    public void deleteById(int id) {
        banjiDao.deleteById(id);
    }

    @Override
    public void add(Banji banji) {
        banjiDao.add(banji);
    }

    @Override
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            banjiDao.deleteById(Integer.parseInt(id));
        }
    }

    @Override
    public Banji selectById(int id) {
        return banjiDao.selectById(id);
    }

    @Override
    public void update(Banji banji) {
        banjiDao.update(banji);
    }

    @Override
    public List<BanjiCountVO> selectBanjiCount() {
        return List.of();
    }
}
