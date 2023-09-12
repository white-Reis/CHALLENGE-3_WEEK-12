package Fabio.ReisChallenge.week.XIII.mshistory.config;

import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.RaceResultService;
import Fabio.ReisChallenge.week.XIII.mshistory.domain.raceResult.entitys.RaceResult;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

@EnableRabbit
@Configuration
public class RabbitMQConfig {

    private final RaceResultService raceResultService;
    private final ObjectMapper objectMapper;

    @Autowired
    public RabbitMQConfig(RaceResultService raceResultService, ObjectMapper objectMapper) {
        this.raceResultService = raceResultService;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "race-queue")
    public void receiveMessage(String message) {
        try {
            RaceResult raceResult = objectMapper.readValue(message, RaceResult.class);
            raceResult.setDate(new Date());
            raceResultService.createRaceResult(raceResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
