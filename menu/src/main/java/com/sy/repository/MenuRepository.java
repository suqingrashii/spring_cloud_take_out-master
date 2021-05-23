package com.sy.repository;

import com.sy.beans.Menu;

import java.util.List;

public interface MenuRepository
{
    public List<Menu> findAll(int index,int limit);
    public int count();
    public Menu findById(Long id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(Long id);
    public List<Menu> findByTid(int index,int limit,Long typeId);
    public int countByTid(Long typeId);
}
