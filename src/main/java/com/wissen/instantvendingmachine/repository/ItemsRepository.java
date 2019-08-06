package com.wissen.instantvendingmachine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wissen.instantvendingmachine.dto.ItemsTraysCombined;
import com.wissen.instantvendingmachine.entity.ItemsEntity;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, Long> {

	@Query("SELECT i.itemID, i.itemName, i.itemPrice, i.itemCategory, t.quantity FROM ItemsEntity i INNER JOIN i.traysEntity as t WHERE i.itemID = t.itemID")
	List<ItemsTraysCombined> fetchItemsTraysDataInnerJoin();
}
