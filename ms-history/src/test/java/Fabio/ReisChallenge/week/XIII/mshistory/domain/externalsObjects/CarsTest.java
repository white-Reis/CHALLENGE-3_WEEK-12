package Fabio.ReisChallenge.week.XIII.mshistory.domain.externalsObjects;

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
        Car car1 = new Car("Toyota", "Camry", new Pilot("John", 30), null);
        Car car2 = new Car("Honda", "Civic", new Pilot("Alice", 25), null);
        carList.add(car1);
        carList.add(car2);

        cars.setCars(carList);

        List<Car> retrievedCars = cars.getCars();

        assertNotNull(retrievedCars);
        assertEquals(2, retrievedCars.size());
        assertEquals(car1, retrievedCars.get(0));
        assertEquals(car2, retrievedCars.get(1));
    }

    @Test
    void setCars() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("Ford", "Focus", new Pilot("Bob", 28), null);
        Car car2 = new Car("Chevrolet", "Cruze", new Pilot("Eve", 35), null);
        carList.add(car1);
        carList.add(car2);

        cars.setCars(carList);

        List<Car> retrievedCars = cars.getCars();

        assertNotNull(retrievedCars);
        assertEquals(2, retrievedCars.size());
        assertEquals(car1, retrievedCars.get(0));
        assertEquals(car2, retrievedCars.get(1));
    }
}