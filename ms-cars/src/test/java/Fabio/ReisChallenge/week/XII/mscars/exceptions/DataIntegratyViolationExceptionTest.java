package Fabio.ReisChallenge.week.XII.mscars.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataIntegratyViolationExceptionTest {
    @Test
    public void testDataIntegratyViolationExceptionMessage() {
        String errorMessage = "This is an error message.";

        DataIntegratyViolationException exception = assertThrows(DataIntegratyViolationException.class, () -> {
            throw new DataIntegratyViolationException(errorMessage);
        });

        assertEquals(errorMessage, exception.getMessage());
    }
}