package pub.guoxin.demo.cloud.intr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Create by guoxin on 2019-03-05
 */
@SpringBootApplication
public class SpringCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }

    // 第一:通过@Bean自定义RouteLocator
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        ZonedDateTime minusTime = LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault());
        String        format    = minusTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("~~~~~~"+format);
        System.out.println("~~~~~~"+format);
        System.out.println("~~~~~~"+format);
        System.out.println("~~~~~~"+format);

        return builder.routes()
                //basic proxy
                .route(r -> r.path("/baidu")
                        .uri("http://baidu.com:80/"))
                .route("after_route", r -> r.after(minusTime)
                        .uri("http://xujin.org"))
                .build();
    }

    /**
     * AfterRoute
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator afterRouteLocator(RouteLocatorBuilder builder) {
        ZonedDateTime minusTime = LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault());
        return builder.routes()
                .route("after_route", r -> r.after(minusTime)
                        .uri("http://xujin.org"))
                .build();
    }
    /*
      错误的示例
      温馨提示，上面这种写法是基于Spring Cloud Gateway FM4的版本，相关代码已废弃，目前Spring Cloud Gateway将会在FM9之后Realese。
     */

//    @Bean
//    public RouteLocator routingConfig() {
//        return Routes.locator()
//                .route("xujin_route")
//                .uri("http://xujin.org")
//                .predicate(host("**.xujin.org"))
//                .build();
//    }
}
