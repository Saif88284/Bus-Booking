package com.bus.Controller;

import com.bus.Entity.Admin;
import com.bus.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class AdminController {

    @Autowired
    private AdminService adminService;

//    @PostMapping("admin")
//    private Map<String , String> registerAdmin(@RequestBody Admin admin){
//       Admin ad =  adminService.register(admin);
//       Map<String , String> response = new HashMap<>();
//       response.put("Status","Succsess");
//       response.put("message","Admin Registerd Siccsessfully");
//       return response;
//    }
        @PostMapping("admin")
        private Map<String , String> registerAdmin(
                @RequestParam String username,
                @RequestParam String password,
                @RequestParam ("file")MultipartFile file
                ) throws IOException {
            Admin ad =  adminService.register(username , password , file);
            Map<String , String> response = new HashMap<>();
            response.put("Status","Succsess");
            response.put("message","Admin Registerd Siccsessfully");
            return response;
        }
        @GetMapping("admin/{id}")
        private ResponseEntity<?> getDataByID(@PathVariable long id
        ){
           Admin admin= adminService.getDataById(id);
           return new ResponseEntity<>(admin, HttpStatus.OK);
        }
}
