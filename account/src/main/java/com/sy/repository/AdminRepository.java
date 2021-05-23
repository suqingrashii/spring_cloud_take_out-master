package com.sy.repository;

import com.sy.beans.Admin;

public interface AdminRepository
{
    public Admin adminAccount(Admin admin);

    public Admin findByAdminId(Long id);

    public void updateByAdminId(Admin admin);
}
