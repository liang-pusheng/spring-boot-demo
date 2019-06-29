package com.springbootdemo;

import com.springbootdemo.rabbitmq.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTests {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws InterruptedException {// 收不到消息是因为还没消费，Junit就跑完了
        for (int i = 0; i < 100; i++) {
            Thread.sleep(3000);
            helloSender.send();
        }
    }
}
