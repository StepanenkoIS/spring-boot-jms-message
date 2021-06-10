package is.springbootjmssendmessage.controllers;

import is.springbootjmssendmessage.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @Autowired
    private JmsTemplate jmsTemplate;



    @GetMapping("send")
    public String sendMsg(@RequestParam String message, @RequestParam Integer age) {
        Message msg = new Message(message, age);
        try {
            jmsTemplate.convertAndSend("DEV.QUEUE.1", msg);
            return "OK. send msg: " + msg.toString();
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }

}
