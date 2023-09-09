package Fabio.ReisChallenge.week.XII.mscars.domains.cars;

import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.Car;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.CarDTORequest;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.CarDTOResponse;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.Cars;
import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.PilotRepository;
import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot.Pilot;
import Fabio.ReisChallenge.week.XII.mscars.exceptions.DataIntegratyViolationException;
import Fabio.ReisChallenge.week.XII.mscars.exceptions.ObjectNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class Aggregator {
    private final CarRepository carRepository;
    private final PilotRepository pilotRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;

    public Aggregator(CarRepository carRepository, PilotRepository pilotRepository, ModelMapper modelMapper, Validator validator) {
        this.carRepository = carRepository;
        this.pilotRepository = pilotRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    public void createCar(CarDTORequest carDTORequest) {
        validCar(carDTORequest, validator);
        if (isDuplicate(carDTORequest)) {
            throw new DataIntegratyViolationException("Car or Pilot already registered");
        }
        Car car = modelMapper.map(carDTORequest, Car.class);
        Pilot pilot = car.getPilot();
        car.setPilot(null);
        pilot.setCar(null);

        Car car1 = carRepository.save(car);
        Pilot pilot1 = pilotRepository.save(pilot);

        car1.setPilot(pilot1);
        pilot1.setCar(car1);

        carRepository.save(car1);
        pilotRepository.save(pilot1);

    }

    public void updateCar(Long carId, CarDTORequest updatedCar) {
        Optional<Car> existingCar = carRepository.findById(carId);
        if (existingCar.isPresent()) {
            if (isDuplicate(updatedCar)) {
                throw new DataIntegratyViolationException("Car or Pilot already registered");
            }
            Car carToUpdate = existingCar.get();
            modelMapper.map(updatedCar, carToUpdate);
            carToUpdate.setId(carId);
            carRepository.save(carToUpdate);
        } else {
            throw new ObjectNotFoundException("Car with ID " + carId + " not found.");
        }
    }

    public CarDTOResponse getCarById(Long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            return modelMapper.map(optionalCar.get(), CarDTOResponse.class);
        }
        throw new ObjectNotFoundException("Car with ID " + carId + " not found.");
    }

    public Cars getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<CarDTOResponse> carDTOs = cars.stream()
                .map(car -> modelMapper.map(car, CarDTOResponse.class))
                .collect(Collectors.toList());
        return new Cars(carDTOs);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    public static void validCar(CarDTORequest carRequest, Validator validator) {
        Set<ConstraintViolation<CarDTORequest>> violations = validator.validate(carRequest);
        if (!violations.isEmpty()) {
            List<String> errorMessages = new ArrayList<>();
            for (ConstraintViolation<CarDTORequest> violation : violations) {
                errorMessages.add(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            throw new DataIntegratyViolationException(errorMessages.toString());
        }
    }

    public boolean isDuplicate(CarDTORequest carDTORequest) {
        Optional<Car> optionalCar = carRepository.findByBrandAndModel(carDTORequest.getBrand(), carDTORequest.getModel());
        Optional<Pilot> optionalPilot = pilotRepository.findByNameAndAge(carDTORequest.getPilot().getName(), carDTORequest.getPilot().getAge());
        if (optionalCar.isPresent() && optionalCar.get().getYear().getTime() == carDTORequest.getYear().getTime() ||optionalPilot.isPresent()) {
            return true;
        }
        return false;
    }
}


