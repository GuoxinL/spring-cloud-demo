package pub.guoxin.demo.cloud.dr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by guoxin on 2019-03-05
 */
@FeignClient(name = "producer", fallback = HelloFeignProviderHystrix.class)
public interface HelloFeignService {

    /**
     *
     * @param name
     * @return
     */
    @GetMapping("/hello/")
    String hello(@RequestParam(value = "name") String name);

}
