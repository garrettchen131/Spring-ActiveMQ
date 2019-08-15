package cn.sicnu.main;


import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class Test
{
    public static void main(String[] args)
    {
        new ClassPathXmlApplicationContext("classpath:spring/spring-base.xml");
    }
}
