package net.yorksolutions.doctorbe.controllers;

import net.yorksolutions.doctorbe.models.AppUser;
import net.yorksolutions.doctorbe.models.Appointment;
import net.yorksolutions.doctorbe.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    //Dependency Injection
    private UserService service;
    public UsersController(UserService service){
        this.service = service;
    }


    @GetMapping
    public AppUser getByUsernameAndPassword(@RequestParam String username,
                                            @RequestParam String password) {
        final var user =  service.getByUsernameAndPassword(username, password);

        if (user == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return user;

        // if (user == null)
        //      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        //return new ResponseEntity<>(user, HttpStatus.OK);
        //(public Response Entity and if block are equal to the code here)
    }

    @PostMapping
    public void register(@RequestBody AppUser appUser) {
        try {
            service.register(appUser);
        } catch (Exception e ) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

//  this.http.put(`http://localhost:8080/users/${id}`, appointment)
    @PutMapping("/{id}")
    public void addAppointment(@PathVariable Long id, @RequestBody Appointment appointment){
        try {
            service.addAvailability(id, appointment);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }
}
