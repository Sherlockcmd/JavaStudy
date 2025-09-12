package com.easy.web.dao;

import com.easy.web.pojo.Banji;

import java.util.List;

public interface IBanjiDao {
    List<Banji> selectByPage(Integer offset, Integer limit);
    int selectTotalCount();

    void deleteById(int id);

    void add(Banji banji);

    Banji selectById(int id);

    void update(Banji banji);
}
