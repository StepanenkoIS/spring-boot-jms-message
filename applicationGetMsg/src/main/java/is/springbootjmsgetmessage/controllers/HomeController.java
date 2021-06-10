package is.springbootjmsgetmessage.controllers;

import is.springbootjmsgetmessage.listener.ResponseListener;
import is.springbootjmsgetmessage.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class HomeController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ResponseListener listener;


    @GetMapping("get")
    public CopyOnWriteArrayList<Message> getMsg() {
        try {
            return listener.getMsgList();
        } catch (JmsException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
