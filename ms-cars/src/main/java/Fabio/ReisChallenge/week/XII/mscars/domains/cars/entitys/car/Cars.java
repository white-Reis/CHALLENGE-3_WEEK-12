package Fabio.ReisChallenge.week.XII.mscars.domains.cars.entitys.car;

import lombok.Data;

import java.util.List;

@Data
public class Cars {
    private List<CarDTOResponse> cars;

    public Cars(List<CarDTOResponse> carDTOResponse) {
        this.cars = carDTOResponse;
    }
}

