package Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class CarsTest {
    @Test
    public void testCarDTORequest() {
        List<CarDTOResponse> s = new ArrayList<>();
        Cars cars = new Cars(s);
        assertNotNull(cars);
    }
}