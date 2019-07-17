package com.wissen.InstantVendingMachine.repository.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wissen.InstantVendingMachine.BaseTest;
import com.wissen.instantvendingmachine.entity.EventEntity;
import com.wissen.instantvendingmachine.repository.EventRepository;

public class EventRepositoryTest extends BaseTest {
	@Autowired
	private EventRepository eventRepository;

	@Test
	public void testFindAll() {
		List<EventEntity> event = eventRepository.findAll();
		event.forEach(System.out::println);
	}

}
