package is.springbootjmsgetmessage.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Component
public class ResponseListener {

    private final CopyOnWriteArrayList<is.springbootjmsgetmessage.model.Message> msgList = new CopyOnWriteArrayList();

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receive(Message message) throws JMSException {
        if (message != null) {
            is.springbootjmsgetmessage.model.Message msg = message.getBody(is.springbootjmsgetmessage.model.Message.class);
            msgList.add(msg);
            log.info(msg.toString());
        }
    }

    public CopyOnWriteArrayList<is.springbootjmsgetmessage.model.Message> getMsgList() {
        return msgList;
    }
}
