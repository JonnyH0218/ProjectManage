package com.jhun.service;

import com.jhun.entity.Roles;

import java.util.List;

public interface UserService {
    public Object selectAllUserBypage(int page ,int rows ,Roles roles);

    public Object showAllMessageByUser(int page ,int rows);
}
