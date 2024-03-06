package com.bus.Controller;

import com.bus.Payload.AdminDto;
import com.bus.Repository.AdminLoginRepository;
import com.bus.Service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminLoginController {
    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping("adminlogin")
    private Map<String , String> adminlogin(@RequestBody AdminDto admindto){
       AdminDto dto =  adminLoginService.adminLogin(admindto);
       Map<String , String >response = new HashMap<>();
       response.put("Status" , "Succsess");
       response.put("message" , "Login Succsessfully");
       return response;
    }

    @PostMapping("adminlogout/{key}")
    private ResponseEntity<?> logout(@PathVariable String key){
        adminLoginService.adminlogout(key);
        return new ResponseEntity<>("logout", HttpStatus.OK);
    }
}
