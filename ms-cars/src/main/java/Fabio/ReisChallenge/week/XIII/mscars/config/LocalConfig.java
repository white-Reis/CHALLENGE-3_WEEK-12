package Fabio.ReisChallenge.week.XIII.mscars.config;

import Fabio.ReisChallenge.week.XIII.mscars.domains.cars.Aggregator;
import Fabio.ReisChallenge.week.XIII.mscars.domains.cars.entitys.car.CarDTORequest;
import Fabio.ReisChallenge.week.XIII.mscars.domains.pilot.entitys.pilot.PilotDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@Configuration
@Profile("local")
public class LocalConfig {

    private Aggregator aggregator;

   public LocalConfig(Aggregator aggregator) {
        this.aggregator = aggregator;
    }


    @Bean
    public void startDB() {
        PilotDTORequest p0 = new PilotDTORequest("Ayrton Senna", 32);
        CarDTORequest f0 = new CarDTORequest("BMW", "i8", p0, new Date(2022, 0, 0));
        aggregator.createCar(f0);
        PilotDTORequest p1 = new PilotDTORequest("Lewis Hamilton", 37);
        CarDTORequest f1 = new CarDTORequest("Mercedes", "AMG GT", p1, new Date(2023, 0, 0));
        aggregator.createCar(f1);
        PilotDTORequest p2 = new PilotDTORequest("Sebastian Vettel", 34);
        CarDTORequest f2 = new CarDTORequest("Aston Martin", "Vantage", p2, new Date(2023, 0, 0));
        aggregator.createCar(f2);
        PilotDTORequest p3 = new PilotDTORequest("Max Verstappen", 24);
        CarDTORequest f3 = new CarDTORequest("Red Bull Racing", "RB16B", p3, new Date(2023, 0, 0));
        aggregator.createCar(f3);
        PilotDTORequest p4 = new PilotDTORequest("Charles Leclerc", 24);
        CarDTORequest f4 = new CarDTORequest("Ferrari", "SF21", p4, new Date(2023, 0, 0));
        aggregator.createCar(f4);
        PilotDTORequest p5 = new PilotDTORequest("Valtteri Bottas", 32);
        CarDTORequest f5 = new CarDTORequest("Alfa Romeo", "C41", p5, new Date(2023, 0, 0));
        aggregator.createCar(f5);
    }
}
