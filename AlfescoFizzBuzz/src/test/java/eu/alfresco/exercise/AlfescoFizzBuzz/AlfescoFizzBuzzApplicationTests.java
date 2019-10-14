package eu.alfresco.exercise.AlfescoFizzBuzz;

import eu.alfresco.exercise.AlfescoFizzBuzz.service.FizzBuzz;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlfescoFizzBuzzApplicationTests {

	@InjectMocks
	private FizzBuzz fizzBuzz;

	@Spy
	private FizzReport fizzReport;

	private FizzRange fizzRange;

	@Before
	public void init(){
		fizzRange = new FizzRange(1,20);
		fizzBuzz.start(fizzRange);
	}

	@Test
	public void shouldReturnStringFromEx2() {
		String expectedResult = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz";
		String actualResult = fizzBuzz.getResultForStep2();

		assertEquals(expectedResult,actualResult);

	}

	@Test
	public void shouldReturnStringFromEx3() {
		String expectedResult = "fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10";
		String actualResult = fizzBuzz.getReport();

		assertEquals(expectedResult,actualResult);

	}



}
