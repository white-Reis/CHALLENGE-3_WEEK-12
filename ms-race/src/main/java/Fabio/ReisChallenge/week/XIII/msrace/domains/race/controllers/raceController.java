package Fabio.ReisChallenge.week.XIII.msrace.domains.race.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/race")
public class raceController {

    @GetMapping
    String hello (){
        return "hello";
    }
}
