package Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car;

import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot.PilotDTORequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
public class CarDTORequestTest {

    @Test
    public void testCarDTORequest() {
        CarDTORequest carDTO = new CarDTORequest("Toyota", "Camry", new PilotDTORequest(), new Date());
        assertNotNull(carDTO);
    }

}