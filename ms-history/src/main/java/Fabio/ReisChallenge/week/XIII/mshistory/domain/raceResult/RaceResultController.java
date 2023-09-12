package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult;


import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys.RaceResultDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/history")
public class RaceResultController {

    private RaceResultService raceResultService;

    public void RaceResultDTOResponse(RaceResultService raceResultService) {
        this.raceResultService = raceResultService;
    }

    public RaceResultController(RaceResultService raceResultService) {
        this.raceResultService = raceResultService;
    }


    @GetMapping("/{raceResultId}")
    public ResponseEntity<RaceResultDTOResponse> getCarById(@PathVariable String raceResultId) {
        RaceResultDTOResponse raceResultDTO = raceResultService.getRaceResultById(raceResultId);
        return ResponseEntity.ok(raceResultDTO);
    }

    @GetMapping
    public ResponseEntity<List<RaceResultDTOResponse>> getAllCars() {
        List<RaceResultDTOResponse> raceResultDTOs = raceResultService.getAllRaceResults();
        return ResponseEntity.ok(raceResultDTOs);
    }
}
