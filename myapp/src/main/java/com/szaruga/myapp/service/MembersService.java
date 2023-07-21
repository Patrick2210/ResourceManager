package com.szaruga.myapp.service;

import com.szaruga.myapp.entity.Members;

import java.util.List;

public interface MembersService {
    List<Members> findAllMembers();

    Members findMemberById(int theId);

    Members saveMember(Members theMember);

    void deleteMemberById(int theId);
}
