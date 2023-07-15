package com.szaruga.myapp.dao;

import com.szaruga.myapp.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Integer> {
}
