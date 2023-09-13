package Fabio.ReisChallenge.week.XII.msrace.domains.race;

import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTORequest;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTOResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/race")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;

    }

   @PostMapping
    public ResponseEntity<Void> createRace(@RequestBody RaceDTORequest raceDTORequest) throws JsonProcessingException {
        raceService.createRace(raceDTORequest);
       return ResponseEntity.status(HttpStatus.CREATED).build();
   }

   @GetMapping("/{raceId}")
    public ResponseEntity<RaceDTOResponse> getRaceById(@PathVariable Long raceId){
        RaceDTOResponse race = raceService.getRaceById(raceId);
        return ResponseEntity.ok(race);
   }

    @GetMapping
    public ResponseEntity<List<RaceDTOResponse>> getAllCars() {
        List<RaceDTOResponse> carDTOs = raceService.listAllRaces();
        return ResponseEntity.ok(carDTOs);
    }

}