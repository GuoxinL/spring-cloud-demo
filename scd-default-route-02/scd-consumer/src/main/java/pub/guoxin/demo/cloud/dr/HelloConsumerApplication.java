package pub.guoxin.demo.cloud.dr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Create by guoxin on 2019-03-05
 */
@EnableFeignClients
@SpringBootApplication
public class HelloConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloConsumerApplication.class, args);
    }
}
