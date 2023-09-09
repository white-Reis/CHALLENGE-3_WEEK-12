package Fabio.ReisChallenge.week.XIII.mscars.domains.cars.entitys.car;

import Fabio.ReisChallenge.week.XIII.mscars.domains.pilot.entitys.pilot.Pilot;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String brand;
    private String model;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_id")
    private Pilot pilot;
    private Date year;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return  Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(year, car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, year);
    }

}

