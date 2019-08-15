package cn.sicnu.test;

import cn.sicnu.service.IMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring/spring-base.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJMSProducer
{
    @Autowired
    private IMessageService messageService;
    @Test
    public void testSend() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            int temp = i;
            new Thread(() -> {
                this.messageService.send(Thread.currentThread().getName() + "23333" + temp);
            },"消息生产者" + i).start();
            Thread.sleep(20);
        }
    }
}
