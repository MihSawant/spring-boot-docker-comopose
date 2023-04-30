package sawant.mihir.springbootdockercompose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sawant.mihir.springbootdockercompose.model.Person;
import sawant.mihir.springbootdockercompose.repository.PersonRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons/all")
    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    @GetMapping("/persons/find/{name}")
    public ResponseEntity<?> getPersonByName(@PathVariable String name){
        Optional<Person> person = personRepository.findByNameIgnoreCase(name);
        if(person.isEmpty()){
            var pd  = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404),
                    "Person Not Found"
            );
            pd.setType(URI.create("http://localhost:8080/person/not-found"));
            pd.setTitle("Person Error");
            return new ResponseEntity<>(
                    pd,
                    HttpStatusCode.valueOf(404));
        } else{
            return new ResponseEntity<>(person, HttpStatusCode.valueOf(200));
        }
    }

}
