package com.abc.pgtest.shard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pg
 * @date 2020/9/27
 */
@TableName("user")
@Data
public class UserEntity {
    private Long id;

    private String name;

    private int age;

}
