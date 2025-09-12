package com.easy.web.service;

import com.easy.web.pojo.Banji;
import com.easy.web.pojo.vo.BanjiCountVO;
import com.easy.web.util.PageResult;

import java.util.List;

public interface IBanjiService {
    PageResult<Banji> selectByPage(Integer page, Integer limit);

    void deleteById(int id);

    void add(Banji banji);

    void deleteAll(String[] ids);

    Banji selectById(int id);

    void update(Banji banji);

    List<BanjiCountVO> selectBanjiCount();
}
