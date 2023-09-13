package Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.*;

    @SpringBootTest
    public class CarTest {

        @Test
        public void testEquals() {

            Car car1 = new Car(1L, "Toyota", "Camry", null, new Date());
            Car car2 = new Car(1L, "Toyota", "Camry", null, new Date());


            assertTrue(car1.equals(car2));
        }

        @Test
        public void testNotEquals() {

            Car car1 = new Car(1L, "Toyota", "Camry", null, new Date());
            Car car2 = new Car(2L, "Honda", "Civic", null, new Date());


            assertFalse(car1.equals(car2));
        }

        @Test
        public void testHashCode() {

            Car car1 = new Car(1L, "Toyota", "Camry", null, new Date());
            Car car2 = new Car(1L, "Toyota", "Camry", null, new Date());


            assertEquals(car1.hashCode(), car2.hashCode());
        }

        @Test
        public void testHashCodeNotEquals() {

            Car car1 = new Car(1L, "Toyota", "Camry", null, new Date());
            Car car2 = new Car(2L, "Honda", "Civic", null, new Date());


            assertNotEquals(car1.hashCode(), car2.hashCode());
        }
}