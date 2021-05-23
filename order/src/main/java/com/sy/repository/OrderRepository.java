package com.sy.repository;

import com.sy.beans.Order;

import java.util.List;

public interface OrderRepository
{
    public List<Order> findByUid(int index, int limit , Long uid);

    public void save(Order order);

    public void deleteById(Long id);

    public int countByUid(Long id);

    public List<Order> findByState(int index, int limit , Long state);

    public int countByState(Long state);

    public List<Order> findByStateOne(int index, int limit , Long state);

    public void updateById(Order order);
}
