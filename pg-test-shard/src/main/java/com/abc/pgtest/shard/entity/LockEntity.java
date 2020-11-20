package com.abc.pgtest.shard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pg
 * @date 2020/9/28
 */
@Data
@TableName("tb_lock")
public class LockEntity {

    private Long id;
    private String name;
}
