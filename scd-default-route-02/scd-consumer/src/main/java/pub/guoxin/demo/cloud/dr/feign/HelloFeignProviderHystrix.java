package pub.guoxin.demo.cloud.dr.feign;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by guoxin on 2019-03-05
 */
@Service
public class HelloFeignProviderHystrix implements HelloFeignService {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "Hello World!";
    }

}