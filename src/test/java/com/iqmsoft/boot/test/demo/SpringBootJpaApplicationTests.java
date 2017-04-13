package com.iqmsoft.boot.test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
@PropertySource("classpath:application-test.properties")
public class SpringBootJpaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
