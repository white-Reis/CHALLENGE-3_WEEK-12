package Fabio.ReisChallenge.week.XIII.msrace.domains.race;

import Fabio.ReisChallenge.week.XIII.msrace.domains.race.entitys.race.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface RaceRepository extends JpaRepository<Race,Long> {
}
