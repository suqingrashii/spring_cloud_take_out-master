package com.sy.handler;

import com.sy.beans.Admin;
import com.sy.beans.User;
import com.sy.repository.AdminRepository;
import com.sy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountHandler
{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/userAccount")
    public User userAccount(@RequestBody User user )
    {
        return userRepository.userAccount(user);
    }

    @PostMapping("/adminAccount")
    public Admin adminAccount(@RequestBody Admin admin )
    {
        return adminRepository.adminAccount(admin);
    }

    @GetMapping("/findByAdminId/{id}")
    public Admin findByAdminId(@PathVariable("id") Long id)
    {
        return adminRepository.findByAdminId(id);
    }

    @PostMapping("/updateByAdminId")
    public void updateByAdminId(@RequestBody Admin admin)
    {
        adminRepository.updateByAdminId(admin);
    }
}
