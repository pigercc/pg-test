package com.abc.pgtest.shard.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * 存放HikariDataSource数据源
 * @Auther: Lee
 * @Date: 2019/1/4 14:11
 */
@Data
@ConfigurationProperties(prefix = "spring.shardingsphere")
public class ShardingProperties {
    private Map<String, HikariDataSource> dataSource = new HashMap<>();
}
