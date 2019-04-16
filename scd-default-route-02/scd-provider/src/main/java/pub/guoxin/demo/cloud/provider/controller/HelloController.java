package pub.guoxin.demo.cloud.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by guoxin on 2019-03-05
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping("")
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

}
