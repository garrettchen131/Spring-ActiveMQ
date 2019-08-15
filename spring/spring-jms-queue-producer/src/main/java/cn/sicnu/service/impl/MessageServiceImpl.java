package cn.sicnu.service.impl;

import cn.sicnu.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class MessageServiceImpl implements IMessageService
{
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination destination;
    @Override
    public void send(String msg)
    {
        this.jmsTemplate.send(this.destination, new MessageCreator()
        {
            @Override
            public Message createMessage(Session session) throws JMSException
            {
                return session.createTextMessage(msg);
            }
        });
    }
}
