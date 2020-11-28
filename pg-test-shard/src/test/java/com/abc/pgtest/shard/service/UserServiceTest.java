package com.abc.pgtest.shard.service;

import com.abc.pgtest.shard.entity.UserEntity;
import com.liying.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author pg
 * @date 2020/9/27
 */
public class UserServiceTest extends BaseSpringTest {

    @Autowired
    UserService userService;

    @Test
    public void batch()
    {
        long count=0;
        List list =new ArrayList<>();
        while (count++<1000)
        {
            UserEntity userEntity =new UserEntity();
            userEntity.setName("batch-"+count);
            userEntity.setAge(18);
            list.add(userEntity);
        }
        boolean result =userService.saveBatch(list);
        log.info("批量插入结果 {}",result);
    }


}