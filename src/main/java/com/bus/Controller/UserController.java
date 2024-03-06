package com.bus.Controller;

import com.bus.Entity.User;
import com.bus.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("userRegistration")
    private ResponseEntity<?> userReg(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam long contact,
            @RequestParam ("file")MultipartFile file
            ) throws Exception{
        User us =userService.registration(username , password , firstName , lastName ,contact ,file);
        return new ResponseEntity<>("User Succsessfully registered" , HttpStatus.CREATED);
    }
}
