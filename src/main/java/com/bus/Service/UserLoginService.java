package com.bus.Service;

import com.bus.CurrentSession.UserCurrentSession;
import com.bus.Entity.User;
import com.bus.Exception.UserLoginExcption;
import com.bus.Payload.UserDto;
import com.bus.Repository.UserLoginRespository;
import com.bus.Repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserLoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginRespository userLoginRespository;

    public UserDto UserLogin(UserDto userDto) {
        User user = userRepository.findByContact(userDto.getContact());
        if (user==null){
            throw new UserLoginExcption("please enter valid Contact");
        }
        if (userLoginRespository.existsByUserId(user.getUserId())) {
            throw new UserLoginExcption("User alredy logdin");
        }
        if (user.getPassword().equals(userDto.getPassword())){
            String make = RandomString.make(3);
            UserCurrentSession us = new UserCurrentSession();
            us.setUserId(userDto.getUserId());
            us.setUUID(make);
            us.setLocalDateTime(LocalDateTime.now());
            userLoginRespository.save(us);
            return userDto;
        }else {
            throw new UserLoginExcption("password is invalid");
        }
    }
}
