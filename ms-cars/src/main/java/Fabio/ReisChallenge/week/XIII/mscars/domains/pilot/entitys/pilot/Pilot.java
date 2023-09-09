package Fabio.ReisChallenge.week.XIII.mscars.domains.pilot.entitys.pilot;

import Fabio.ReisChallenge.week.XIII.mscars.domains.cars.entitys.car.Car;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Integer age;

    @OneToOne
    @JoinColumn(name="car_id")
    @JsonBackReference
    private Car car;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return Objects.equals(id, pilot.id) &&
                Objects.equals(name, pilot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
