package com.pgtest;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author pg
 * @date 2020/11/28
 */
public class FluxTest {


    @Test
    public void testSubscribe(){
        Flux<String> flux1 =Flux.just("hello1");
        flux1.subscribe(System.out::print);

        Flux<String> flux2 =Flux.just("hello2");

        flux2.subscribe(this::write);

    }

    private void write(String content)
    {
        try {
            FileUtils.writeLines(new File("tmp.log"), Arrays.asList(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
