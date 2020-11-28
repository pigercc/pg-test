package com.liying;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author pg
 * @date 2020/9/27
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseSpringTest {

    protected Logger log = LoggerFactory.getLogger(this.getClass());
}
