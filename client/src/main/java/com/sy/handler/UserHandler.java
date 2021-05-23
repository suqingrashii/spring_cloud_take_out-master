package com.sy.handler;

import com.sy.beans.User;
import com.sy.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Userclient")
public class UserHandler
{
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit)
    {
        return userFeign.findAll(index,limit);
    }
    @GetMapping("count")
    public int count()
    {
        return userFeign.count();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id)
    {
        User user01 =userFeign.findById(id);
        user01.setPassword(null);
        return user01;
    }

    @PostMapping("/updateById")
    public boolean updateById(@RequestBody User user)
    {
        userFeign.updateById(user);
        return true;
    }

    @PostMapping("/update")
    public boolean update(@RequestBody User user)
    {
        return userFeign.update(user);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteById(Long id)
    {
//        System.out.println("------------------"+id);
        return userFeign.deleteById(id);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody User user)
    {
        return userFeign.save(user);
    }
}
