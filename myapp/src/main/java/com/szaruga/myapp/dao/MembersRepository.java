package com.szaruga.myapp.dao;

import com.szaruga.myapp.entity.Items;
import com.szaruga.myapp.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembersRepository extends JpaRepository<Members, Integer> {
}
