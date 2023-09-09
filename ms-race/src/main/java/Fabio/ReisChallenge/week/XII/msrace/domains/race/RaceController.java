package Fabio.ReisChallenge.week.XII.msrace.domains.race;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/race")
public class RaceController {

    @GetMapping
    String hello (){
        return "hello";
    }
}
