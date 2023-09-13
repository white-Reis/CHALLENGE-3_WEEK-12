package Fabio.ReisChallenge.week.XII.msrace.domains.race.processors;

import org.junit.jupiter.api.Test;
import Fabio.ReisChallenge.week.XII.msrace.config.RabbitMQConfig;
import Fabio.ReisChallenge.week.XII.msrace.domains.cars.CarsFeignClient;
import Fabio.ReisChallenge.week.XII.msrace.domains.cars.entitys.Car;
import Fabio.ReisChallenge.week.XII.msrace.domains.cars.entitys.Cars;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.Race;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.task.TaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RaceSimulatorTest {

    @Mock
    private CarsFeignClient carsFeignClient;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private TaskExecutor taskExecutor;

    @Mock
    private RabbitTemplate rabbitTemplate;

    private RaceSimulator raceSimulator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        raceSimulator = new RaceSimulator(carsFeignClient, modelMapper, taskExecutor, rabbitTemplate);
    }

    @Test
    void testStartRace() throws JsonProcessingException {

        Race race = new Race();

        Cars cars = new Cars();
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        carList.add(new Car());
        carList.add(new Car());
        cars.setCars(carList);

        RaceResult raceResult = new RaceResult();

        when(modelMapper.map(race, RaceResult.class)).thenReturn(raceResult);

        when(carsFeignClient.getCars()).thenReturn(cars);

        Boolean result = raceSimulator.startRace(race);

        assertEquals(false, result);
    }

    @Test
    void testProcessRace() throws JsonProcessingException {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        carList.add(new Car());
        carList.add(new Car());
        RaceResult raceResult = new RaceResult();

        Mockito.doAnswer(invocation -> {
            Runnable runnable = invocation.getArgument(0);
            runnable.run();
            return null;
        }).when(taskExecutor).execute(Mockito.any(Runnable.class));

        CompletableFuture<Void> future = raceSimulator.processRace(carList, raceResult);

        future.join();

        Mockito.verify(rabbitTemplate).convertAndSend(
                Mockito.eq(RabbitMQConfig.EXCHANGE_NAME),
                Mockito.eq(RabbitMQConfig.QUEUE_NAME),
                Mockito.anyString()
        );
    }
}
