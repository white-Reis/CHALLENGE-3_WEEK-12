package Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceDTORequestTest {

    private RaceDTORequest raceDTORequest;

    @BeforeEach
    void setUp() {
        raceDTORequest = new RaceDTORequest();
    }

    @Test
    void getName() {
        raceDTORequest.setName("Grand Prix");
        assertEquals("Grand Prix", raceDTORequest.getName());
    }

    @Test
    void getCountry() {
        raceDTORequest.setCountry("United States");
        assertEquals("United States", raceDTORequest.getCountry());
    }

    @Test
    void setName() {
        raceDTORequest.setName("Formula One");
        assertEquals("Formula One", raceDTORequest.getName());
    }

    @Test
    void setCountry() {
        raceDTORequest.setCountry("Brazil");
        assertEquals("Brazil", raceDTORequest.getCountry());
    }

}