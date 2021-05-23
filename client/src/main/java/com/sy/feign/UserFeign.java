package com.sy.feign;

import com.sy.beans.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//,fallback = UserFeignError.class
@FeignClient(value = "user")
public interface UserFeign
{
    @GetMapping("/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);


    @GetMapping("/user/count")
    public int count();

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") Long id);

    @PostMapping("/user/update")
    public boolean update(@RequestBody User user);


    @DeleteMapping("/user/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") Long id);

    @PostMapping("/user/save")
    public boolean save(@RequestBody User user);

    @PostMapping("/user/updateById")
    public void updateById(@RequestBody User user);

}
