package Fabio.ReisChallenge.week.XII.msrace.domains.cars.entitys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    void getCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry", null, null));
        carList.add(new Car("Honda", "Civic", null, null));

        cars.setCars(carList);

        assertEquals(carList, cars.getCars());
    }

    @Test
    void setCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Ford", "Focus", null, null));
        carList.add(new Car("Chevrolet", "Malibu", null, null));

        cars.setCars(carList);

        assertEquals(carList, cars.getCars());
    }
}