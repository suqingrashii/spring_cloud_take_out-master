package com.sy.handler;

import com.sy.beans.Order;
import com.sy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler
{
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/findByUid/{index}/{limit}/{uid}")
    public List<Order> findByUid(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("uid") Long uid)
    {
        index=(index-1)*limit;
        return orderRepository.findByUid(index,limit,uid);
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order)
    {
        Calendar calendar= Calendar.getInstance();
        Date date=calendar.getTime();
        order.setDate(date);
        orderRepository.save(order);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id)
    {
        orderRepository.deleteById(id);
    }

    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") Long uid)
    {
        return orderRepository.countByUid(uid);
    }

    @GetMapping("/findByState/{index}/{limit}/{state}")
    public List<Order> findByState(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("state") Long state)
    {
        index=(index-1)*limit;
        return orderRepository.findByState(index,limit,state);
    }

    @GetMapping("/findByStateOne/{index}/{limit}/{state}")
    public List<Order> findByStateOne(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("state") Long state)
    {
        index=(index-1)*limit;
        return orderRepository.findByStateOne(index,limit,state);
    }

    @GetMapping("/countByState/{state}")
    public int countByState(@PathVariable("state") Long state)
    {
        return orderRepository.countByState(state);
    }

    @PostMapping("/updateById")
    public void updateById(@RequestBody Order order)
    {
        orderRepository.updateById(order);
    }
}
