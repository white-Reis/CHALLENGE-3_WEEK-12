package Fabio.ReisChallenge.week.XII.msrace.domains.cars;

import Fabio.ReisChallenge.week.XII.msrace.domains.cars.enitys.Cars;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name = "cars-service", url = "http://localhost:8081/api/v1/cars")
public interface CarsFeignClient{

    @GetMapping
    Cars getCars();
}
