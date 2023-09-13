package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys;

import Fabio.ReisChallenge.week.XIII.mshistory.domain.externalsObjects.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RaceResultDTOResponseTest {

    private RaceResultDTOResponse raceResultDTO;

    @BeforeEach
    void setUp() {
        raceResultDTO = new RaceResultDTOResponse();
    }

    @Test
    void getId() {
        assertNull(raceResultDTO.getId());
    }

    @Test
    void getName() {
        assertNull(raceResultDTO.getName());
    }

    @Test
    void getCountry() {
        assertNull(raceResultDTO.getCountry());
    }

    @Test
    void getDate() {
        assertNull(raceResultDTO.getDate());
    }

    @Test
    void getWinner() {
        assertNull(raceResultDTO.getWinner());
    }

    @Test
    void getSecondPlace() {
        assertNull(raceResultDTO.getSecondPlace());
    }

    @Test
    void getThirdPlace() {
        assertNull(raceResultDTO.getThirdPlace());
    }

    @Test
    void setId() {
        String id = "1";
        raceResultDTO.setId(id);
        assertEquals(id, raceResultDTO.getId());
    }

    @Test
    void setName() {
        String name = "RaceName";
        raceResultDTO.setName(name);
        assertEquals(name, raceResultDTO.getName());
    }

    @Test
    void setCountry() {
        String country = "Country";
        raceResultDTO.setCountry(country);
        assertEquals(country, raceResultDTO.getCountry());
    }

    @Test
    void setDate() {
        Date date = new Date();
        raceResultDTO.setDate(date);
        assertEquals(date, raceResultDTO.getDate());
    }

    @Test
    void setWinner() {
        Car winner = new Car();
        raceResultDTO.setWinner(winner);
        assertEquals(winner, raceResultDTO.getWinner());
    }

    @Test
    void setSecondPlace() {
        Car secondPlace = new Car();
        raceResultDTO.setSecondPlace(secondPlace);
        assertEquals(secondPlace, raceResultDTO.getSecondPlace());
    }

    @Test
    void setThirdPlace() {
        Car thirdPlace = new Car();
        raceResultDTO.setThirdPlace(thirdPlace);
        assertEquals(thirdPlace, raceResultDTO.getThirdPlace());
    }
}
