package Fabio.ReisChallenge.week.XII.mscars.domains.cars;

import Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    Optional<Car> findByBrandAndModel(String brand, String model);
}
