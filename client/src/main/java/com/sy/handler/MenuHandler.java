package com.sy.handler;

import com.sy.beans.Menu;
import com.sy.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Menuclient")
public class MenuHandler
{
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit)
    {
        return menuFeign.findAll(index,limit);
    }
    @GetMapping("count")
    public int count()
    {
        return menuFeign.count();
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") Long id)
    {
        System.out.println("------------------" +id);
        return menuFeign.findById(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Menu menu)
    {
        return menuFeign.update(menu);
    }
    @DeleteMapping("/deleteById")
    public boolean deleteById(Long id)
    {
        System.out.println("------------------"+id);
        return menuFeign.deleteById(id);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Menu menu)
    {
        return menuFeign.save(menu);
    }

    @GetMapping("/countByTid/{typeId}")
    public int countByTid(@PathVariable("typeId") Long typeId)
    {
        return menuFeign.countByTid(typeId);
    }

    @GetMapping("/findByTid/{index}/{limit}/{typeId}")
    public List<Menu> findByTid(@PathVariable("index") int index,@PathVariable("limit") int limit,@PathVariable("typeId") Long typeId)
    {
        return  menuFeign.findByTid(index,limit,typeId);
    }
}
