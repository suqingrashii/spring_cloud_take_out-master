package com.sy.handler;

import com.sy.beans.User;
import com.sy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler
{
    @Autowired
    private UserRepository userRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index()
    {
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit)
    {
        index = (index-1)*limit;
        return  userRepository.findAll(index,limit);
    }

    @GetMapping("/count")
    public int count()
    {
        return userRepository.count();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id)
    {
        return userRepository.findById(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody User user)
    {
        userRepository.update(user);
        return true;
    }

    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") Long id)
    {
        System.out.println("--------------------------"+id);
        userRepository.deleteById(id);
        return true;
    }
    @PostMapping("/save")
    public boolean save(@RequestBody User user)
    {
        userRepository.save(user);
        return true;
    }

    @PostMapping("/updateById")
    public void updateById(@RequestBody User user)
    {
        userRepository.updateById(user);
    }
}
