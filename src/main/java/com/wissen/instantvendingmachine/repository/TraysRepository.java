package com.wissen.instantvendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.instantvendingmachine.entity.TraysEntity;

@Repository
public interface TraysRepository extends JpaRepository<TraysEntity, Integer> {

}
