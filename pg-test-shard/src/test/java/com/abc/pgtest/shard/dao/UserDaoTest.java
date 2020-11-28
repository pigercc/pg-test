package com.abc.pgtest.shard.dao;

import com.abc.pgtest.shard.entity.UserEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liying.BaseSpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author pg
 * @date 2020/9/27
 */
public class UserDaoTest extends BaseSpringTest {

    @Autowired
    UserDao userDao;

    @Test
    public void query()
    {
        List list =userDao.selectList(new QueryWrapper<>());
        Assert.assertTrue(list.size() >0);
    }

    @Test
    public void queryById()
    {
        UserEntity userEntity =userDao.selectById(1310147057939464196L);
        Assert.assertNotNull(userEntity);
    }
    @Test
    public void queryByName()
    {
        UserEntity filter =new UserEntity();
        filter.setName("batch-793");
        UserEntity userEntity =userDao.selectOne(new QueryWrapper<>(filter));
        Assert.assertNotNull(userEntity);
    }


    @Test
    public void insert()
    {
        long count=0;
        while (count++ <1000)
        {
            UserEntity userEntity =new UserEntity();
            userEntity.setAge(99);
            userEntity.setName("shard-insert-"+count);
            int ret = userDao.insert(userEntity);
            log.info("插入 {} 结果 {}",userEntity,ret);
        }

    }
}