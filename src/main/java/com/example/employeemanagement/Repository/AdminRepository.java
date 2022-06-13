package com.example.employeemanagement.Repository;

import com.example.employeemanagement.Entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
    public Admin findByEmail(String email);
}
