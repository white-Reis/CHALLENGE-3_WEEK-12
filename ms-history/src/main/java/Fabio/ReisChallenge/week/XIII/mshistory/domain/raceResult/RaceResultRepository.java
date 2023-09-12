package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult;

import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys.RaceResult;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RaceResultRepository extends MongoRepository<RaceResult, String> {
}
