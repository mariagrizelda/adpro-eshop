package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class EshopApplicationTests {

	@Test
	public void contextLoads() {
		Assertions.assertDoesNotThrow(() -> EshopApplication.main(new String[]{}));
	}
}
