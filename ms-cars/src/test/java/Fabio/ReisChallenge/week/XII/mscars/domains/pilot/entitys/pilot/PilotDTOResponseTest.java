package Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class PilotDTOResponseTest {
    @Test
    public void testPilotDTOResponse() {

        PilotDTOResponse pilot = new PilotDTOResponse(1L, "John", 30);

        assertEquals(1L, pilot.getId().longValue());
        assertEquals("John", pilot.getName());
        assertEquals(30, pilot.getAge());
    }

}