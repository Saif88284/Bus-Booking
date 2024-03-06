package com.bus.Service;

import com.bus.Entity.Admin;
import com.bus.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

//    public Admin register(Admin admin) {
//        if (adminRepository.existsByUsername(admin.getUsername())){
//            throw new AdminException("Admin alredy registerd");
//        }
//        adminRepository.save(admin);
//        return admin;
//    }

    public Admin register(String username, String password,  MultipartFile file) throws IOException {
        Admin a = new Admin();
        a.setUsername(username);
        a.setPassword(password);
        a.setProfilePicture(file.getBytes());
        adminRepository.save(a);
        return null;
    }

    public Admin getDataById(long id) {
        Admin admin = adminRepository.findById(id).get();
        return admin;
    }
}
