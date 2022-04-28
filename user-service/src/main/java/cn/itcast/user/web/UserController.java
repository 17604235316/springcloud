package cn.itcast.user.web;

import cn.itcast.user.config.PatternPropertiesConfig;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//方法一 实现配置的热更新
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;


   /* @Value("${pattern.dataformat}")
    private String dataformat;*/

    @Autowired
    private PatternPropertiesConfig patternPropertiesConfig;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping("now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternPropertiesConfig.getDataformat()));
    }
    @GetMapping("share")
    public PatternPropertiesConfig share(){
        return patternPropertiesConfig;
    }
}
