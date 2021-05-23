package com.sy.feign;

import com.sy.beans.Admin;
import com.sy.beans.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "account")
public interface AccountFeign
{
    @PostMapping("/account/userAccount")
    public User userAccount(@RequestBody User user );

    @PostMapping("/account/adminAccount")
    public Admin adminAccount(@RequestBody Admin admin );

    @GetMapping("/account/findByAdminId/{id}")
    public Admin findByAdminId(@PathVariable("id") Long id);

    @PostMapping("/account/updateByAdminId")
    public void updateByAdminId(@RequestBody Admin admin);
}
