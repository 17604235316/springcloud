package cn.itcast.order.config;

import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;


/**
 * 自定义feign配置，修改log级别
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }
}
