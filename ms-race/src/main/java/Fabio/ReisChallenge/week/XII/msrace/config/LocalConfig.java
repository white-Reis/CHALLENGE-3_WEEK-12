package Fabio.ReisChallenge.week.XII.msrace.config;


import Fabio.ReisChallenge.week.XII.msrace.domains.race.RaceService;
import Fabio.ReisChallenge.week.XII.msrace.domains.race.entitys.race.RaceDTORequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@Configuration
@Profile("local")
public class LocalConfig {

    private RaceService raceService;

   public LocalConfig( RaceService raceService) {
       this.raceService = raceService;

    }


    @Bean
    public void startDB() throws JsonProcessingException {
        RaceDTORequest raceDTORequest =new RaceDTORequest("Beira Mar","Brasil",new Date());
        raceService.createRace(raceDTORequest);
    }
}
