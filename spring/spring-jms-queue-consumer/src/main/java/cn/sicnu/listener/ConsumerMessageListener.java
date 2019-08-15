package cn.sicnu.listener;

import cn.sicnu.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class ConsumerMessageListener implements MessageListener
{

    @Autowired
    private IMessageService messageService;
    @Override
    public void onMessage(Message message)
    {
        if (message instanceof TextMessage)
        {
            TextMessage msg = (TextMessage) message;
            try
            {
                this.messageService.handle(msg.getText());
            } catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
    }
}
