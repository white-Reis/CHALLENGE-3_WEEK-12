package Fabio.ReisChallenge.week.XII.mscars.domains.cars;

import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.Car;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.CarDTORequest;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.Cars;
import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.PilotRepository;
import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot.Pilot;
import Fabio.ReisChallenge.week.XII.mscars.domains.pilot.entitys.pilot.PilotDTORequest;
import Fabio.ReisChallenge.week.XII.mscars.exceptions.ObjectNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AggregatorTest {

    @InjectMocks
    private Aggregator aggregator;

    @Mock
    private CarRepository carRepository;

    @Mock
    private PilotRepository pilotRepository;

    @Spy
    private ModelMapper modelMapper;

    @Spy
    private Validator validator;

    @Test
    void updateCar() {
        Long carId = 1L;
        PilotDTORequest p0 = new PilotDTORequest("Ayrton Senna", 32);
        CarDTORequest f0 = new CarDTORequest("BMW", "i8", p0, new Date(122, 1, 1));


        when(carRepository.findById(carId)).thenReturn(Optional.of(new Car()));
        when(carRepository.save(any(Car.class))).thenReturn(new Car());

        aggregator.updateCar(carId, f0);

        verify(carRepository, times(1)).save(any());

    }

    @Test
    void updateClassNotFound() {
        Long carId = 1L;
        CarDTORequest updatedCarDTO = new CarDTORequest();

        when(carRepository.findById(carId)).thenReturn(Optional.empty());

        assertThrows(ObjectNotFoundException.class, () -> {
            aggregator.updateCar(carId, updatedCarDTO);
        });
    }

    @Test
    void getCarById() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ObjectNotFoundException.class, () -> aggregator.getCarById(1L));
    }

    @Test
    void getAllCars() {
        List<Car> carList = new ArrayList<>();
        when(carRepository.findAll()).thenReturn(carList);

        Cars cars = aggregator.getAllCars();
        assertNotNull(cars);
    }

    @Test
    void deleteCar() {
        Long carId = 1L;
        aggregator.deleteCar(carId);
        verify(carRepository, times(1)).deleteById(carId);
    }

    @Test
    void validCar() {
        CarDTORequest validCarDTO = new CarDTORequest();
        validCarDTO.setBrand("Toyota");
        validCarDTO.setModel("Camry");
        validCarDTO.setYear(new Date());

        assertDoesNotThrow(() -> {
            aggregator.validCar(validCarDTO, validator);
        });
    }

    @Test
    public void testIsDuplicateCarFound() {
        CarDTORequest carDTORequest = new CarDTORequest();
        carDTORequest.setBrand("Toyota");
        carDTORequest.setModel("Camry");
        carDTORequest.setYear(new Date(123, 0, 0));
        carDTORequest.setPilot(new PilotDTORequest());

        when(carRepository.findByBrandAndModel(carDTORequest.getBrand(), carDTORequest.getModel()))
                .thenReturn(Optional.of(new Car(1L, "Toyota", "Camry", new Pilot(), new Date(123, 0, 0))));

        boolean result = aggregator.isDuplicate(carDTORequest);

        assertTrue("Duplicate car should return true", result);
    }

    @Test
    public void testIsDuplicatePilotFound() {
        CarDTORequest carDTORequest = new CarDTORequest();
        carDTORequest.setPilot(new PilotDTORequest("John", 30)); // Assume a pilot with the same name and age exists

        when(pilotRepository.findByNameAndAge(carDTORequest.getPilot().getName(), carDTORequest.getPilot().getAge()))
                .thenReturn(Optional.of(new Pilot()));

        boolean result = aggregator.isDuplicate(carDTORequest);

        assertTrue("Duplicate pilot should return true", result);
    }

    @Test
    public void testIsDuplicateNoDuplicate() {
        CarDTORequest carDTORequest = new CarDTORequest();
        PilotDTORequest pilotDTORequest = new PilotDTORequest();
        carDTORequest.setPilot(pilotDTORequest);

        when(carRepository.findByBrandAndModel(any(), any())).thenReturn(Optional.empty());
        when(pilotRepository.findByNameAndAge(any(), any())).thenReturn(Optional.empty());

        boolean result = aggregator.isDuplicate(carDTORequest);

        assertFalse("No duplicate should return false", result);
    }
}