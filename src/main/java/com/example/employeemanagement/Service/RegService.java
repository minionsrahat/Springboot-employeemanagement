package com.example.employeemanagement.Service;


import com.example.employeemanagement.Entity.Admin;
import com.example.employeemanagement.Repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RegService {
    private AdminRepository adminRepository;
    public Map<String, Object> saveAdminRegistrationCredintials(Admin admin){
        Map<String, Object> map=new HashMap<>();
        Optional<Admin> optionalAdmin= Optional.ofNullable(adminRepository.findByEmail(admin.getEmail()));
        if(optionalAdmin.isPresent()){
            map.put("error",true);
            map.put("msg","Email already Exists! Please Choose Another one");
        }
        else {
            map.put("error",false);
            Admin saveAdmin=adminRepository.save(admin);
            map.put("admin",saveAdmin);
        }
        return  map;

    }

}
