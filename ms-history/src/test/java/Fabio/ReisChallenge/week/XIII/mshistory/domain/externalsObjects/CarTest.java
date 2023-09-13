package Fabio.ReisChallenge.week.XIII.mshistory.domain.externalsObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void getBrand() {
        car.setBrand("Toyota");
        assertEquals("Toyota", car.getBrand());
    }

    @Test
    void getModel() {
        car.setModel("Camry");
        assertEquals("Camry", car.getModel());
    }

    @Test
    void getPilot() {
        Pilot pilot = new Pilot();
        car.setPilot(pilot);
        assertEquals(pilot, car.getPilot());
    }

    @Test
    void getYear() {
        Date year = new Date();
        car.setYear(year);
        assertEquals(year, car.getYear());
    }

    @Test
    void setBrand() {
        car.setBrand("Honda");
        assertEquals("Honda", car.getBrand());
    }

    @Test
    void setModel() {
        car.setModel("Accord");
        assertEquals("Accord", car.getModel());
    }

    @Test
    void setPilot() {
        Pilot pilot = new Pilot();
        car.setPilot(pilot);
        assertEquals(pilot, car.getPilot());
    }

    @Test
    void setYear() {
        Date year = new Date();
        car.setYear(year);
        assertEquals(year, car.getYear());
    }
}