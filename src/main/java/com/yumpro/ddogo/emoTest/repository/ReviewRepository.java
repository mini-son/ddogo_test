package com.yumpro.ddogo.emoTest.repository;

import com.yumpro.ddogo.emoTest.entity.Emoreview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Emoreview, Integer> {
}
