package com.abc.pgtest.shard.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liying.pgtest.core.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author pg
 * @date 2020/9/28
 */
public class LockDaoTest extends BaseSpringTest {

    @Autowired
    LockDao lockDao;

    @Test
    public void test()
    {
        long count =lockDao.selectCount(new QueryWrapper<>());
        System.out.println(count);
    }

}