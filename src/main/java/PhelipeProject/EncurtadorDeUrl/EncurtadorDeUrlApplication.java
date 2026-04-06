package PhelipeProject.EncurtadorDeUrl;

import PhelipeProject.EncurtadorDeUrl.service.ObterUrlEncurtada;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EncurtadorDeUrlApplication   {

	public static void main(String[] args) {
		SpringApplication.run(EncurtadorDeUrlApplication.class, args);
	}
}
