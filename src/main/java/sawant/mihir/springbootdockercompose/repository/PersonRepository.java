package sawant.mihir.springbootdockercompose.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sawant.mihir.springbootdockercompose.model.Person;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {

    Optional<Person> findByNameIgnoreCase(String name);
}
