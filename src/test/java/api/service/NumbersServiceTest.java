package api.service;


import api.exception.CheckRequestStringException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class NumberServiceTest {

    @InjectMocks
    private NumberService service;

    @Test
    public void incrementNumbersInString_Test_Successful() {
        String expected = "15";

        String actual = service.incrementNumbersInString("14");
        assertEquals(expected, actual);
    }

    @Test(expected = CheckRequestStringException.class)
    public void incrementNumbersInString_Test_ExceptionStringWithLetters() {
        service.incrementNumbersInString("12в 13 1445");
    }

    @Test(expected = CheckRequestStringException.class)
    public void incrementNumbersInString_Test_ExceptionNullString() {
        service.incrementNumbersInString(null);
    }

    @Test(expected = CheckRequestStringException.class)
    public void incrementNumbersInString_Test_ExceptionEmptyString() {
        service.incrementNumbersInString("");
    }

    @Test(expected = CheckRequestStringException.class)
    public void incrementNumbersInString_Test_ExceptionOneSpaceString() {
        service.incrementNumbersInString(" ");
    }
}