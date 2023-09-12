package Fabio.ReisChallenge.week.XII.msrace.domains.race.processors;

import Fabio.ReisChallenge.week.XII.msrace.domains.cars.CarsFeignClient;
import Fabio.ReisChallenge.week.XII.msrace.domains.cars.enitys.Car;
import Fabio.ReisChallenge.week.XII.msrace.domains.cars.enitys.Cars;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.Race;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceResult;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class RaceSimulator {
    private CarsFeignClient carsFeignClient;
    private ModelMapper modelMapper;

    public RaceSimulator(CarsFeignClient carsFeignClient, ModelMapper modelMapper) {
        this.carsFeignClient = carsFeignClient;
        this.modelMapper = modelMapper;
    }

    public Boolean startRace(Race raceDTORequest) {
        Cars carsObject = carsFeignClient.getCars();
        List<Car> cars = carsObject.getCars();
        List<Car> shuffledCars = shuffleCars(cars);
        RaceResult raceResult = modelMapper.map(raceDTORequest, RaceResult.class);

        if (shuffledCars.size() < 3) return true;
        processRace(shuffledCars, raceResult);
        return false;
    }

    private CompletableFuture<Void> processRace(List<Car> shuffledCars, RaceResult raceResult) {
        return CompletableFuture.runAsync(() -> {
            List<Car> cars = shuffledCars.subList(0, Math.min(shuffledCars.size(), 10));
            for (int time = 0; time < 300; time++) {
                for (int currentCarIndex = 0; currentCarIndex < cars.size(); currentCarIndex++) {
                    int randomValue = (int) (Math.random() * 100) + 1;
                    if (randomValue > 50 && currentCarIndex > 0) {
                        Car car = cars.get(currentCarIndex);
                        cars.set(currentCarIndex, cars.get(currentCarIndex - 1));
                        cars.set(currentCarIndex - 1, car);
                    }
                }
            }
            raceResult.setWinner(cars.get(0));
            raceResult.setSecondPlace(cars.get(1));
            raceResult.setThirdPlace(cars.get(2));

            publishRaceResults(raceResult);
        });
    }

    private List<Car> shuffleCars(List<Car> carList) {
        List<Car> shuffledCars = new ArrayList<>(carList);
        Collections.shuffle(shuffledCars, new Random());
        return shuffledCars;
    }

    private void publishRaceResults(RaceResult raceResult) {
        System.out.println(1);
    }

}
