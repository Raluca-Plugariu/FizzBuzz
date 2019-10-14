package eu.alfresco.exercise.AlfescoFizzBuzz;

import eu.alfresco.exercise.AlfescoFizzBuzz.util.AbstractTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;


public class IntegrationTest extends AbstractTest {


    @Test
    public void shouldSuccessfullyRun() throws Exception {
        String uri = "/start?rangeMin=1&&rangeMax=20";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();
        String expectedResult = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz";
        assertEquals(expectedResult, content);
    }

    @Test
    public void shouldFailRun() throws Exception {

        String uri = "/start?rangeMin=1&&rangeMax=dummyString";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(400, status);

    }

}
