package com.sy.feign;

import com.sy.beans.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeignError implements UserFeign
{
    @Override
    public List<User> findAll(int index, int limit) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public void updateById(User user){}
}
