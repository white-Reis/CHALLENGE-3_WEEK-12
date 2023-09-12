package Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult;

import Fabio.ReisChallenge.week.XII.mscars.exceptions.ObjectNotFoundException;
import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys.RaceResult;
import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys.RaceResultDTOResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RaceResultService {

    private RaceResultRepository raceResultRepository;

    private ModelMapper modelMapper;

    public RaceResultService(RaceResultRepository raceResultRepository, ModelMapper modelMapper) {

        this.raceResultRepository = raceResultRepository;
        this.modelMapper = modelMapper;
    }

    public void createRaceResult(RaceResult raceResult) {
        raceResultRepository.save(raceResult);
    }

    public List<RaceResultDTOResponse> getAllRaceResults() {
        List<RaceResult> results = raceResultRepository.findAll();
        List<RaceResultDTOResponse> resultDTOResponses = results.stream()
                .map(result -> modelMapper.map(result, RaceResultDTOResponse.class))
                .collect(Collectors.toList());
        return resultDTOResponses;

    }

    public RaceResultDTOResponse getRaceResultById(String id) {
        Optional<RaceResult> raceResultOptional = raceResultRepository.findById(id);
        if (raceResultOptional.isEmpty()) {
            throw new ObjectNotFoundException("Race result not found");
        }
        return modelMapper.map(raceResultOptional.get(), RaceResultDTOResponse.class);
    }
}
