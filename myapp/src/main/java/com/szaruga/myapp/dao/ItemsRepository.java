package com.szaruga.myapp.dao;

import com.szaruga.myapp.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
