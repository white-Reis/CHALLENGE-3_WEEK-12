package Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @Test
    void getId() {
        race.setId(1L);
        assertEquals(1L, race.getId());
    }

    @Test
    void getName() {
        race.setName("Grand Prix");
        assertEquals("Grand Prix", race.getName());
    }

    @Test
    void getCountry() {
        race.setCountry("United States");
        assertEquals("United States", race.getCountry());
    }

    @Test
    void setId() {
        race.setId(2L);
        assertEquals(2L, race.getId());
    }

    @Test
    void setName() {
        race.setName("Formula One");
        assertEquals("Formula One", race.getName());
    }

    @Test
    void setCountry() {
        race.setCountry("Brazil");
        assertEquals("Brazil", race.getCountry());
    }

}