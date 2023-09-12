package Fabio.ReisChallenge.week.XII.mscars.domains.cars.controllers;

import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.CarDTORequest;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.CarDTOResponse;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.Aggregator;
import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private Aggregator aggregator;

    @Autowired
    public CarController(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @PostMapping
    public ResponseEntity<Void> createCar(@RequestBody CarDTORequest carDTO) {
        aggregator.createCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Void> updateCar(@PathVariable Long carId, @RequestBody CarDTORequest updatedCar) {
        aggregator.updateCar(carId, updatedCar);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarDTOResponse> getCarById(@PathVariable Long carId) {
        CarDTOResponse carDTO = aggregator.getCarById(carId);
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping
    public ResponseEntity<Cars> getAllCars() {
        Cars carDTOs = aggregator.getAllCars();
        return ResponseEntity.ok(carDTOs);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        aggregator.deleteCar(carId);
        return ResponseEntity.noContent().build();
    }
}
