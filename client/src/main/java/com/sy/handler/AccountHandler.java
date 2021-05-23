package com.sy.handler;

import com.sy.beans.Admin;
import com.sy.beans.User;
import com.sy.feign.AccountFeign;
import com.sy.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Accountclient")
public class AccountHandler
{
    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/userAccount")
    public String userAccount(@RequestBody User user)
    {
        User user01=accountFeign.userAccount(user);
        if(user01 != null)
        {
            Map<String,Object> userMap = new HashMap<>();
            userMap.put("id",user01.getId());
            userMap.put("name",user01.getNickname());
            userMap.put("authority","user");
            String token = JWTUtils.getToken(userMap);
            return token;
        }else
        {
            return null;
        }
    }

    @PostMapping("/adminAccount")
    public String adminAccount(@RequestBody Admin admin)
    {
        Admin admin01=accountFeign.adminAccount(admin);
        if(admin01 != null)
        {
            Map<String,Object> userMap = new HashMap<>();
            userMap.put("id",admin01.getId());
            userMap.put("name",admin01.getUsername());
            userMap.put("authority","admin");
            String token = JWTUtils.getToken(userMap);
            return token;
        }else
        {
            return null;
        }
    }

    @GetMapping("/findByAdminId/{id}")
    public Admin findByAdminId(@PathVariable("id") Long id)
    {
        return accountFeign.findByAdminId(id);
    }

    @PostMapping("/updateByAdminId")
    public boolean updateByAdminId(@RequestBody Admin admin)
    {
        accountFeign.updateByAdminId(admin);
        return true;
    }
}