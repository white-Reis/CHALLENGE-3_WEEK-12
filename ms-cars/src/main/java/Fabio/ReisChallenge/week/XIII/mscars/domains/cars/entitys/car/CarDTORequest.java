package Fabio.ReisChallenge.week.XIII.mscars.domains.cars.entitys.car;

import Fabio.ReisChallenge.week.XIII.mscars.domains.pilot.entitys.pilot.PilotDTORequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTORequest {
    @NotBlank(message = "Brand cannot be blank")
    private String brand;
    @NotBlank(message = "Model cannot be blank")
    private String model;
    @NotNull(message = "Pilot cannot be blank")
    @Valid
    private PilotDTORequest pilot;
    @NotNull(message = "Year cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;
}
