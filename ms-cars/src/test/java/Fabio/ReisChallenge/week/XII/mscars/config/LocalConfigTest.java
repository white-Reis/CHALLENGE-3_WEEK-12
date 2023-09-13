package Fabio.ReisChallenge.week.XII.mscars.config;

import Fabio.ReisChallenge.week.XII.mscars.domains.cars.Aggregator;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.CarDTORequest;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import org.junit.Before;

import static org.mockito.Mockito.*;

@SpringBootTest
public class LocalConfigTest {

    @Mock
    private Aggregator aggregator;

    private LocalConfig localConfig;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        localConfig = new LocalConfig(aggregator);
    }

    @Test
    public void testStartDB() {

        doNothing().when(aggregator).createCar(any(CarDTORequest.class));

        localConfig.startDB();

        verify(aggregator, atLeastOnce()).createCar(any(CarDTORequest.class));

    }
}
