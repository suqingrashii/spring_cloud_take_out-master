package com.sy.handler;

import com.sy.beans.Menu;
import com.sy.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler
{
    @Autowired
    private MenuRepository menuRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index()
    {
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit)
    {
        index = (index-1)*limit;
        return  menuRepository.findAll(index,limit);
    }

    @GetMapping("/count")
    public int count()
    {
        return menuRepository.count();
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") Long id)
    {
        return menuRepository.findById(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Menu menu)
    {
        menuRepository.update(menu);
        return true;
    }

    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") Long id)
    {
        menuRepository.deleteById(id);
        return true;
    }
    @PostMapping("/save")
    public boolean save(@RequestBody Menu menu)
    {
        menuRepository.save(menu);
        return true;
    }

    @GetMapping("/countByTid/{typeId}")
    public int countByTid(@PathVariable("typeId") Long typeId)
    {
        return menuRepository.countByTid(typeId);
    }

    @GetMapping("/findByTid/{index}/{limit}/{typeId}")
    public List<Menu> findByTid(@PathVariable("index") int index,@PathVariable("limit") int limit,@PathVariable("typeId") Long typeId)
    {
        index = (index-1)*limit;
        return  menuRepository.findByTid(index,limit,typeId);
    }
}
