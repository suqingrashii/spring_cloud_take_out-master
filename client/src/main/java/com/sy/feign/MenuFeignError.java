package com.sy.feign;

import com.sy.beans.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuFeignError implements MenuFeign
{
    @Override
    public List<Menu> findAll(int index, int limit) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Menu findById(Long id) {
        return null;
    }

    @Override
    public boolean update(Menu menu) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean save(Menu menu) {
        return false;
    }

    @Override
    public int countByTid(Long typeId) {
        return 0;
    }

    @Override
    public List<Menu> findByTid(int index, int limit, Long typeId) {
        return null;
    }

}
