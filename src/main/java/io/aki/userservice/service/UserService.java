package io.aki.userservice.service;

import io.aki.userservice.entity.UserName;
import io.aki.userservice.repository.UserRepository;
import io.aki.userservice.valueobjects.Department;
import io.aki.userservice.valueobjects.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    public UserName saveUser(UserName user) {

        log.info("Inside saveuser Method of UserService");
        return userRepository.save(user);
    }

//    public User findUserById(Long userId) {
//
//        log.info("Inside findUser Method of UserService");
//        return userRepository.findByUserId(userId);
//    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        UserName user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://api-gateway/departments/"+user.getDepartmentId(), Department.class);
        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);
        return  responseTemplate;
    }
}
