package Fabio.ReisChallenge.week.XII.msrace.domains.race;

import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.Race;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTORequest;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTOResponse;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.processors.RaceSimulator;
import Fabio.ReisChallenge.week.XII.msrace.exceptions.DataIntegratyViolationException;
import Fabio.ReisChallenge.week.XII.msrace.exceptions.ObjectNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static Fabio.ReisChallenge.week.XII.msrace.domains.race.validator.validRace;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;

    private final RaceSimulator raceSimulator;

    RaceService(RaceRepository raceRepository, ModelMapper modelMapper, Validator validator, RaceSimulator raceSimulator) {
        this.raceRepository = raceRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.raceSimulator = raceSimulator;
    }

    public void createRace(RaceDTORequest raceDTORequest) throws JsonProcessingException {
        validRace(raceDTORequest, validator);
        Optional<Race> optionalRace = raceRepository.findRaceByNameAndCountry(raceDTORequest.getName(), raceDTORequest.getCountry());
        if (optionalRace.isPresent()) {
            throw new DataIntegratyViolationException("Race already registered");
        }
        Race race = modelMapper.map(raceDTORequest, Race.class);
        race.setDate(new Date());
       if( raceSimulator.startRace(race)){
           throw new DataIntegratyViolationException("not enough cars");
       }
        raceRepository.save(race);
    }

    public RaceDTOResponse getRaceById(Long raceId) {
        Optional<Race> optionalRace = raceRepository.findById(raceId);
        if (optionalRace.isPresent()) {
            Race race = optionalRace.get();
            return modelMapper.map(race, RaceDTOResponse.class);
        } else {
            throw new ObjectNotFoundException("Race not found for ID: " + raceId);
        }
    }

    public List<RaceDTOResponse> listAllRaces() {
        List<Race> allRaces = raceRepository.findAll();
        return allRaces.stream()
                .map(race -> modelMapper.map(race, RaceDTOResponse.class))
                .collect(Collectors.toList());
    }
}

