package Fabio.ReisChallenge.week.XII.mscars.handler;

import Fabio.ReisChallenge.week.XII.mscars.exceptions.DataIntegratyViolationException;
import Fabio.ReisChallenge.week.XII.mscars.exceptions.ObjectNotFoundException;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.Assert.*;
public class ControllerExceptionHandlerTest {

    private final ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();

    @Test
   public void testObjectNotFoundExceptionHandling() {
        ObjectNotFoundException ex = new ObjectNotFoundException("Object not found.");
        MockHttpServletRequest request = new MockHttpServletRequest();
        ResponseEntity<StandardError> response = controllerExceptionHandler.objectNotFound(ex, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Object not found.", response.getBody().getError());
    }

    @Test
   public void testDataIntegratyViolationExceptionHandling() {
        DataIntegratyViolationException ex = new DataIntegratyViolationException("Data integrity violation.");
        MockHttpServletRequest request = new MockHttpServletRequest();
        ResponseEntity<StandardError> response = controllerExceptionHandler.dataIntegratyViolation(ex, request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Data integrity violation.", response.getBody().getError());
    }

}