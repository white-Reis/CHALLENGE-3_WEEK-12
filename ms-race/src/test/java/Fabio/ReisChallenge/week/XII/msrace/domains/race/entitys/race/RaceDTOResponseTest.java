package Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceDTOResponseTest {

    private RaceDTOResponse raceDTOResponse;

    @BeforeEach
    void setUp() {
        raceDTOResponse = new RaceDTOResponse();
    }

    @Test
    void getId() {
        raceDTOResponse.setId(1L);
        assertEquals(1L, raceDTOResponse.getId());
    }

    @Test
    void getName() {
        raceDTOResponse.setName("Grand Prix");
        assertEquals("Grand Prix", raceDTOResponse.getName());
    }

    @Test
    void getCountry() {
        raceDTOResponse.setCountry("United States");
        assertEquals("United States", raceDTOResponse.getCountry());
    }

    @Test
    void setId() {
        raceDTOResponse.setId(2L);
        assertEquals(2L, raceDTOResponse.getId());
    }

    @Test
    void setName() {
        raceDTOResponse.setName("Formula One");
        assertEquals("Formula One", raceDTOResponse.getName());
    }

    @Test
    void setCountry() {
        raceDTOResponse.setCountry("Brazil");
        assertEquals("Brazil", raceDTOResponse.getCountry());
    }


}