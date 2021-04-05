package com.example.atm.ATMDemo;

import com.example.atm.ATMDemo.service.ATMSrevice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class AtmDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ATMSrevice atmSrevice;

	@Test
	public void vaildateAmount() {

		Assert.isTrue(atmSrevice.validateAmount(5000));

	}

}
