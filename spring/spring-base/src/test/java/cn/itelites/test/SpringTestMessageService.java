package cn.itelites.test;

import cn.itelites.service.IMessageService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestMessageService
{
    @Autowired
    private IMessageService messageService;

    @Test
    public void testEcho()
    {
        String echoMessage = this.messageService.echo("Hello Spring!");
        TestCase.assertEquals(echoMessage,"【ECHO】Hello Spring!");
    }
}
