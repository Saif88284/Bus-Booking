package com.bus.Service;

import com.bus.Entity.Admin;
import com.bus.Exception.AdminloginExcption;
import com.bus.Payload.AdminDto;
import com.bus.CurrentSession.AdminCurrentSession;
import com.bus.Repository.AdminLoginRepository;
import com.bus.Repository.AdminRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminLoginService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminLoginRepository adminLoginRepository;

    public AdminDto adminLogin(AdminDto admindto) {
        Admin ad = adminRepository.findByUsername(admindto.getUsername());
        System.out.println(ad);
        if (ad==null){
            throw new AdminloginExcption("please enter valid username");
       }
        Optional<AdminCurrentSession> byId = adminLoginRepository.findById(ad.getId());
        if (byId.isPresent()){
            throw new AdminloginExcption("Admin is alredy login");
        }
        if (ad.getPassword().equals(admindto.getPassword())){
            String string = RandomString.make(2);
            AdminCurrentSession a = new AdminCurrentSession();
            a.setId(ad.getId());
            a.setUUId(string);
            AdminCurrentSession save = adminLoginRepository.save(a);
            admindto.setId(save.getId());
            return admindto;
        }else {
            throw new AdminloginExcption("password is invalid");
        }
    }

    public void adminlogout(String key) {
        AdminCurrentSession byUUId = adminLoginRepository.findByUUId(key);
        if(byUUId==null){
            throw new AdminloginExcption("admin not found");
        }
        adminLoginRepository.delete(byUUId);

    }
}
