package com.complainmanagement.controller;


import com.complainmanagement.pojo.ApplicationUser;
import com.complainmanagement.repository.ApplicationUserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody String user) {
        final JSONObject obj = new JSONObject(user);
        ApplicationUser user1 = new ApplicationUser();
        user1.setUsername(obj.getString("username"));
        user1.setPassword(bCryptPasswordEncoder.encode(obj.getString("password")));
        applicationUserRepository.save(user1);
        return "saved";
    }
}