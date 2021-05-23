package com.sy.handler;

import com.sy.beans.Order;
import com.sy.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orderclient")
public class OrderHandler
{
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/findByUid/{index}/{limit}/{uid}")
    public List<Order> findByUid(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("uid") Long uid)
    {
        return orderFeign.findByUid(index,limit,uid);
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody Order order)
    {
        orderFeign.save(order);
        return true;
    }

    @DeleteMapping("/deleteById/{id}")
    public Boolean deleteById(@PathVariable Long id)
    {
        orderFeign.deleteById(id);
        return true;
    }

    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") Long uid)
    {
        return orderFeign.countByUid(uid);
    }

    @GetMapping("/findByState/{index}/{limit}/{state}")
    public List<Order> findByState(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("state") Long state)
    {
        return orderFeign.findByState(index,limit,state);
    }

    @GetMapping("/findByStateOne/{index}/{limit}/{state}")
    public List<Order> findByStateOne(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("state") Long state)
    {
        return orderFeign.findByStateOne(index,limit,state);
    }

    @GetMapping("/countByState/{state}")
    public int countByState(@PathVariable("state") Long state)
    {
        return orderFeign.countByState(state);
    }

    @PostMapping("/updateById")
    public Boolean updateById(@RequestBody Order order)
    {
        orderFeign.updateById(order);
        return true;
    }

}
