package com.abc.pgtest.shard.config;

import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配置数据源
 * @Auther: Lee
 * @Date: 2019/1/4 14:17
 */

@Configuration
@EnableConfigurationProperties(ShardingProperties.class)
public class ShardingConfig {


    @Autowired
    private ShardingProperties shardingProperties;

    /**
     * 配置数据源
     *
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource dataSource() throws SQLException {


        // To configure the table rules for Order
        TableRuleConfiguration userConfig = new TableRuleConfiguration();
        userConfig.setLogicTable("user");
        userConfig.setActualDataNodes("ds0.user_${0..9}");


        // To configure the strategy for table Sharding.
        userConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user_${id % 10}"));

        // To configure the strategy rule of Sharding
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(userConfig);
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.putAll(shardingProperties.getDataSource());
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap(), new Properties());
    }

}
