package net.yorksolutions.doctorbe.repositories;

import net.yorksolutions.doctorbe.models.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository<AppUser, Long> {
    public Optional<AppUser> findAppUserByUsernameAndPassword(String username, String password);

    public Optional<AppUser> findAppUserByUsername (String username);
}
