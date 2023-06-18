package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.User;
import com.example.demo.entities.value_objects.Department;
import com.example.demo.entities.value_objects.ResponseTemplateVO;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	private final UserRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository repository,
                       RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }


    public User save(User user) {
        return this.repository.save(user);
    }

    public User getById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        User user = this.getById(id);

        Department department = restTemplate.getForObject("http://service01/service01/" + user.getDepartmentId(), Department.class);

        return new ResponseTemplateVO(user, department);
    }
}
