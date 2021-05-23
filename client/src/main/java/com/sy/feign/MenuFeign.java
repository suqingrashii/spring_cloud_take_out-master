package com.sy.feign;

import com.sy.beans.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "menu",fallback = MenuFeignError.class )
public interface MenuFeign
{
    @GetMapping("/menu/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/menu/count")
    public int count();

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") Long id);

    @PostMapping("/menu/update")
    public boolean update(@RequestBody Menu menu);

    @DeleteMapping("/menu/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") Long id);

    @PostMapping("/menu/save")
    public boolean save(@RequestBody Menu menu);

    @GetMapping("/menu/countByTid/{typeId}")
    public int countByTid(@PathVariable("typeId") Long typeId);

    @GetMapping("/menu/findByTid/{index}/{limit}/{typeId}")
    public List<Menu> findByTid(@PathVariable("index") int index,@PathVariable("limit") int limit,@PathVariable("typeId") Long typeId);
}
