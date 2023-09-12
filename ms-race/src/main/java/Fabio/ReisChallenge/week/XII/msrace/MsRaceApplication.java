package Fabio.ReisChallenge.week.XII.msrace;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableRabbit
@EnableFeignClients(basePackages = "Fabio.ReisChallenge.week.XII.msrace")
public class MsRaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRaceApplication.class, args);
	}

}
