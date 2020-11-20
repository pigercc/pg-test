package com.abc.pgtest.shard.service;

import com.abc.pgtest.shard.dao.UserDao;
import com.abc.pgtest.shard.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @author pg
 * @date 2020/9/27
 */
@Service
public class UserService extends ServiceImpl<UserDao, UserEntity> {

}
