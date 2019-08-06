package com.wissen.instantvendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.instantvendingmachine.entity.TrayComptEntity;

@Repository
public interface TrayComptRepository extends JpaRepository<TrayComptEntity, Long> {

	TrayComptEntity getAllByCompartment(String compartmentName);

	TrayComptEntity getOneByTrayID(long trayID);

}
