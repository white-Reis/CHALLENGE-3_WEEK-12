package Fabio.ReisChallenge.week.XII.msrace.domains.cars.entitys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilotTest {

    private Pilot pilot;

    @BeforeEach
    void setUp() {
        pilot = new Pilot();
    }

    @Test
    void getName() {
        pilot.setName("John");
        assertEquals("John", pilot.getName());
    }

    @Test
    void getAge() {
        pilot.setAge(30);
        assertEquals(30, pilot.getAge());
    }

    @Test
    void setName() {
        pilot.setName("Alice");
        assertEquals("Alice", pilot.getName());
    }

    @Test
    void setAge() {
        pilot.setAge(25);
        assertEquals(25, pilot.getAge());
    }
}