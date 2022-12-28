package net.yorksolutions.doctorbe.services;
import net.yorksolutions.doctorbe.models.AppUser;
import net.yorksolutions.doctorbe.models.Appointment;
import net.yorksolutions.doctorbe.models.Foo;
import net.yorksolutions.doctorbe.repositories.AppointmentRepository;
import net.yorksolutions.doctorbe.repositories.FooRepository;
import net.yorksolutions.doctorbe.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


//Services in Spring:
//  dedicated to handling logic
//  available to be injected anywhere
//  meant to be as pure Java as possible

@Service
public class UserService {
    private final UserRepository repository;
    private final AppointmentRepository appointmentRepository;
    private final FooRepository fooRepository;


    public UserService(UserRepository repository, AppointmentRepository appointmentRepository, FooRepository fooRepository) {
        this.repository = repository;
        this.appointmentRepository = appointmentRepository;
        this.fooRepository = fooRepository;
    }


    public AppUser getByUsernameAndPassword(String username,
                                            String password) {
        return repository
                .findAppUserByUsernameAndPassword(username, password)
                .orElse(null);
    }

    public void register (AppUser appUser) throws Exception {
        if (repository.findAppUserByUsername(appUser.username).isPresent())
            throw new Exception();

        ////////12/20/22-01-00:50:00
        Foo foo = new Foo(); //we are creating a new entity
        foo.name = appUser.username; //we fill that entity with data
        this.fooRepository.save(foo); // sending it to the db

        appUser.fooList.add(foo); //this adds the object (created in the lines above) to the appUser FooList
        repository.save(appUser); //this is the function that saves to the db
        ////////////////////////////
    }

    //Using the Optional path
    public void register2(AppUser appUser) throws Exception {
            Optional<AppUser> appUserOpt = repository.findAppUserByUsername(appUser.username);
            if (appUserOpt.isEmpty()) {
                repository.save(appUser);
            } else {
                throw new Exception();
            }
    }

    public void addAvailability(Long doctorId, Appointment appointment){
        final var doctor =repository.findById(doctorId).orElseThrow();
        final var appointmentToAdd = appointmentRepository.findById(appointment.id).orElseThrow();
        doctor.appointments.add(appointment);
        repository.save(doctor);

    }

    ///////////////////////


}
