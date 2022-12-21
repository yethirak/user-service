package io.aki.userservice.controller;

import io.aki.userservice.entity.UserName;
import io.aki.userservice.service.UserService;
import io.aki.userservice.valueobjects.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserName saveUser(@RequestBody UserName user){
        log.info("Inside saveUser Method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId){
        return userService.getUserWithDepartment(userId);
    }

  /*  @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        log.info("Inside findUser Method of UserController");
        return userService.findUserById(userId);
    }*/

}
