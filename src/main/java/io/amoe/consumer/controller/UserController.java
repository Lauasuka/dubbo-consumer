package io.amoe.consumer.controller;

import io.amoe.faced.IUserService;
import io.amoe.pojo.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Amoe
 * @date 2019/4/3 0:36
 */
@RestController
public class UserController {

    @Reference
    private IUserService userService;

    @GetMapping("users")
    public List<User> userList() {
        return userService.listUser();
    }

    @GetMapping("user/id/{id}")
    public User queryUserById(@PathVariable Long id) {
        return userService.queryUserById(id);
    }

    @GetMapping("user/name/{name}")
    public List<User> queryUserByName(@PathVariable String name) {
        return userService.queryUserByName(name);
    }

    @GetMapping("user/phone/{phone}")
    public List<User> queryUserByPhone(@PathVariable String phone) {
        return userService.queryUserByPhone(phone);
    }

    @PostMapping("user")
    public int updateUser(User user) {
        return userService.updateUser(user);
    }
}
