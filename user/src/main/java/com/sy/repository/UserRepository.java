package com.sy.repository;

import com.sy.beans.User;

import java.util.List;

public interface UserRepository
{
    public List<User> findAll(int index, int limit);
    public int count();
    public User findById(Long id);
    public void save(User user);
    public void update(User user);
    public void deleteById(Long id);
    public void updateById(User user);
}
