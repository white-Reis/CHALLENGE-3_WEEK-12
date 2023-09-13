package Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car;

import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot.PilotDTOResponse;
import org.junit.Test;


import java.util.Date;

import static org.junit.Assert.*;

public class CarDTOResponseTest {

    @Test
    public void testCarDTOResponse() {
        CarDTOResponse carDTO = new CarDTOResponse(1l,"BMW","i8",new PilotDTOResponse(),new Date(122,1,1));
        assertNotNull(carDTO);
    }
}