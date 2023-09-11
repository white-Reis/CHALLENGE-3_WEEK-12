package Fabio.ReisChallenge.week.XII.msrace.domains.race;

import Fabio.ReisChallenge.week.XII.msrace.domains.cars.CarsFeignClient;
import Fabio.ReisChallenge.week.XII.msrace.domains.cars.enitys.Cars;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/race")
public class RaceController {

    private final CarsFeignClient carsFeignClient;

    public RaceController(CarsFeignClient carsFeignClient) {
        this.carsFeignClient = carsFeignClient;
    }

    @GetMapping
    public Cars getCarsFromCarsService() {
        return carsFeignClient.getCars();
    }
}