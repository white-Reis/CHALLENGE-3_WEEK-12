package Fabio.ReisChallenge.week.XII.msrace.domains.cars;

import Fabio.ReisChallenge.week.XII.msrace.domains.cars.entitys.Cars;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name = "car-service", url = "http://ms-cars:8081/api/v1/cars")
public interface CarsFeignClient{

    @GetMapping
    Cars getCars();
}
