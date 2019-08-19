package cn.dm.common;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Queue;
import java.io.Serializable;

@Component
public class MqUtils implements Serializable{

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(String queueName,Object object){
        Queue queue=new ActiveMQQueue(queueName);
        this.jmsMessagingTemplate.convertAndSend(queue,object);
    }
}
