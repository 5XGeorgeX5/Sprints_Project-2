package com.team2.library;

import com.team2.library.common.controller.DevController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryApplicationTests {

	@Autowired(required = false)
	private DevController devController;

	@Test
	void excludedControllerShouldBeNull() {
		assertNull(devController);
	}

}
