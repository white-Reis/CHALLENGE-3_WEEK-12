package Fabio.ReisChallenge.week.XIII.mscars.domains.pilot;

import Fabio.ReisChallenge.week.XIII.mscars.domains.cars.entitys.car.Car;
import Fabio.ReisChallenge.week.XIII.mscars.domains.pilot.entitys.pilot.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PilotRepository extends JpaRepository<Pilot,Long> {
    Optional<Pilot> findByNameAndAge(String name,Integer age);
}
