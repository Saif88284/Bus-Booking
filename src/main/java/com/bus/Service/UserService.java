package com.bus.Service;

import com.bus.Entity.User;
import com.bus.Exception.UserExcption;
import com.bus.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registration(String username, String password, String firstName, String lastName, long contact, MultipartFile file) throws Exception{
        User user = new User();
        if (userRepository.existsByUsername(user.getUsername())){
            throw new UserExcption("User already registered");
        }
        if (userRepository.existsByFirstName(user.getFirstName())){
            throw new UserExcption("User already registered");
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setContact(contact);
        user.setProfilePicture(file.getBytes());
        userRepository.save(user);
        return user;
    }

    }

//    public User registration(User user, MultipartFile file) throws Exception {
//        if (userRepository.existsByUsername(user.getUsername())){
//            throw new UserExcption("User already registered");
//        }
//        if (userRepository.existsByFirstName(user.getFirstName())){
//            throw new UserExcption("User already registered");
//        }
//        User u = new User();
//        u.setProfilePicture(file.getBytes());
//        userRepository.save(user);
//        return user;
//    }

