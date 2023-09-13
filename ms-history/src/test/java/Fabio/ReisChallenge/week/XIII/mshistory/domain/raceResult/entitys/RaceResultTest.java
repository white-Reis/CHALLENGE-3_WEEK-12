package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys;

import Fabio.ReisChallenge.week.XIII.mshistory.domain.externalsObjects.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {

    private RaceResult raceResult;

    @BeforeEach
    void setUp() {
        raceResult = new RaceResult();
    }

    @Test
    void getId() {
        assertNull(raceResult.getId());
    }

    @Test
    void getName() {
        assertNull(raceResult.getName());
    }

    @Test
    void getCountry() {
        assertNull(raceResult.getCountry());
    }

    @Test
    void getDate() {
        assertNull(raceResult.getDate());
    }

    @Test
    void getWinner() {
        assertNull(raceResult.getWinner());
    }

    @Test
    void getSecondPlace() {
        assertNull(raceResult.getSecondPlace());
    }

    @Test
    void getThirdPlace() {
        assertNull(raceResult.getThirdPlace());
    }

    @Test
    void setId() {
        String id = "1";
        raceResult.setId(id);
        assertEquals(id, raceResult.getId());
    }

    @Test
    void setName() {
        String name = "RaceName";
        raceResult.setName(name);
        assertEquals(name, raceResult.getName());
    }

    @Test
    void setCountry() {
        String country = "Country";
        raceResult.setCountry(country);
        assertEquals(country, raceResult.getCountry());
    }

    @Test
    void setDate() {
        Date date = new Date();
        raceResult.setDate(date);
        assertEquals(date, raceResult.getDate());
    }

    @Test
    void setWinner() {
        Car winner = new Car();
        raceResult.setWinner(winner);
        assertEquals(winner, raceResult.getWinner());
    }

    @Test
    void setSecondPlace() {
        Car secondPlace = new Car();
        raceResult.setSecondPlace(secondPlace);
        assertEquals(secondPlace, raceResult.getSecondPlace());
    }

    @Test
    void setThirdPlace() {
        Car thirdPlace = new Car();

        raceResult.setThirdPlace(thirdPlace);
        assertEquals(thirdPlace, raceResult.getThirdPlace());
    }
}
