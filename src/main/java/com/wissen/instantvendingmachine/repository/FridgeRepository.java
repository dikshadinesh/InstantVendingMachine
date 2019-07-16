package com.wissen.instantvendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.instantvendingmachine.entity.FridgeEntity;

@Repository
public interface FridgeRepository extends JpaRepository<FridgeEntity, Integer> {
}
