package eu.alfresco.exercise.AlfescoFizzBuzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlfescoFizzBuzzApplicationTests {

	@Mock
	private FizzBuzz fizzBuzz;

	@Test
	public void shouldReturnStringFromEx2() {
		String expectedResult = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz";
		FizzRange fizzRange = new FizzRange(1,20);
		Mockito.doCallRealMethod().when(fizzBuzz).printResultForStepTwo(fizzRange);

		assertEquals(expectedResult,fizzBuzz.printResultForStepTwo(fizzRange));

	}

}
