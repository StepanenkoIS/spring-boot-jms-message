package is.springbootjmssendmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringBootJmsGetMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJmsGetMessageApplication.class, args);
    }

}
