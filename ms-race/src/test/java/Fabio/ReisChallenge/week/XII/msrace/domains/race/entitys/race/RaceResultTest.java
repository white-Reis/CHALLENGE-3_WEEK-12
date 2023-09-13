package Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race;

import Fabio.ReisChallenge.week.XII.msrace.domains.cars.entitys.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {

    private RaceResult raceResult;

    @BeforeEach
    void setUp() {
        raceResult = new RaceResult();
    }

    @Test
    void getName() {
        raceResult.setName("Grand Prix");
        assertEquals("Grand Prix", raceResult.getName());
    }

    @Test
    void getCountry() {
        raceResult.setCountry("United States");
        assertEquals("United States", raceResult.getCountry());
    }

    @Test
    void getWinner() {
        Car winner = new Car();
        raceResult.setWinner(winner);
        assertEquals(winner, raceResult.getWinner());
    }

    @Test
    void getSecondPlace() {
        Car secondPlace = new Car();
        raceResult.setSecondPlace(secondPlace);
        assertEquals(secondPlace, raceResult.getSecondPlace());
    }

    @Test
    void getThirdPlace() {
        Car thirdPlace = new Car();
        raceResult.setThirdPlace(thirdPlace);
        assertEquals(thirdPlace, raceResult.getThirdPlace());
    }

    @Test
    void setName() {
        raceResult.setName("Formula One");
        assertEquals("Formula One", raceResult.getName());
    }

    @Test
    void setCountry() {
        raceResult.setCountry("Brazil");
        assertEquals("Brazil", raceResult.getCountry());
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