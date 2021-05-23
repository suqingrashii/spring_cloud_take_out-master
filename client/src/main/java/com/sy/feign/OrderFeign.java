package com.sy.feign;

import com.sy.beans.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign
{
    @GetMapping("/order/findByUid/{index}/{limit}/{uid}")
    public List<Order> findByUid(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("uid") Long uid);

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @DeleteMapping("/order/deleteById/{id}")
    public void deleteById(@PathVariable Long id);

    @GetMapping("/order/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") Long uid);

    @GetMapping("/order/findByState/{index}/{limit}/{state}")
    public List<Order> findByState(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("state") Long state);

    @GetMapping("/order/countByState/{state}")
    public int countByState(@PathVariable("state") Long state);

    @GetMapping("/order/findByStateOne/{index}/{limit}/{state}")
    public List<Order> findByStateOne(@PathVariable("index")int index, @PathVariable("limit")int limit , @PathVariable("state") Long state);

    @PostMapping("/order/updateById")
    public void updateById(@RequestBody Order order);

}
