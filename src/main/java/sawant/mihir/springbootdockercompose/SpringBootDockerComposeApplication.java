package sawant.mihir.springbootdockercompose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sawant.mihir.springbootdockercompose.model.Person;
import sawant.mihir.springbootdockercompose.repository.PersonRepository;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootDockerComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerComposeApplication.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @Bean
    CommandLineRunner dataLoader(){
        return args -> {

            personRepository.insert(Arrays.asList(
                    new Person("Mihir", "maharashtra"),
                    new Person("shayan", "delhi"),
                    new Person("Hari", "kerala"),
                    new Person("Suresh", "rajasthan")
            ));

            personRepository.findAll().forEach(System.out::println);
        };

    }
}
