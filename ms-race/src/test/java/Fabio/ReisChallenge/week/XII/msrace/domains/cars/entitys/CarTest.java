package Fabio.ReisChallenge.week.XII.msrace.domains.cars.entitys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Pilot pilot = new Pilot("John",25);
        car.setPilot(pilot);
        assertEquals(pilot, car.getPilot());
    }


    @Test
    void setBrand() {
        car.setBrand("Honda");
        assertEquals("Honda", car.getBrand());
    }

    @Test
    void setModel() {
        car.setModel("Civic");
        assertEquals("Civic", car.getModel());
    }

    @Test
    void setPilot() {
        Pilot pilot = new Pilot("Alice",25);
        car.setPilot(pilot);
        assertEquals(pilot, car.getPilot());
    }

}