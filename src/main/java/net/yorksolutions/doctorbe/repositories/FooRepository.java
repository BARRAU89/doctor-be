package net.yorksolutions.doctorbe.repositories;
import net.yorksolutions.doctorbe.models.Foo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends CrudRepository<Foo, Long> {



}
