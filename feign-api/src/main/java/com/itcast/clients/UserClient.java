package com.itcast.clients;

import com.itcast.config.DefaultFeignConfiguration;
import com.itcast.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userservice", configuration = DefaultFeignConfiguration.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    User getUSerById(@PathVariable("id") long id);
}
