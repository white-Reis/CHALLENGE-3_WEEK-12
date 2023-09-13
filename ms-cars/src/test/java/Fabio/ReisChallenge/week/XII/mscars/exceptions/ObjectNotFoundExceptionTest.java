package Fabio.ReisChallenge.week.XII.mscars.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectNotFoundExceptionTest {
    @Test
   public void testObjectNotFoundExceptionMessage() {
        String errorMessage = "Object not found.";

        ObjectNotFoundException exception = assertThrows(ObjectNotFoundException.class, () -> {
            throw new ObjectNotFoundException(errorMessage);
        });

        assertEquals(errorMessage, exception.getMessage());
    }
}