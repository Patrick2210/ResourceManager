package com.szaruga.myapp.service;

import com.szaruga.myapp.entity.Members;

import java.util.List;

public interface MembersService {
    List<Members> findAll();

    Members findById(int theId);

    Members save(Members theEmployee);

    void deleteById(int theId);
}
