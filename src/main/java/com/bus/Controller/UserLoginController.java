package com.bus.Controller;

import com.bus.Payload.UserDto;
import com.bus.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("userlogin")
    private Map <String , String>userlogin(@RequestBody UserDto userDto){
        UserDto dto =userLoginService.UserLogin(userDto);
        Map<String , String> response =  new HashMap<>();
        response.put("Status" , "Succsess");
        response.put("Message" ,"User login succsessfully");
        return response;
    }
}
