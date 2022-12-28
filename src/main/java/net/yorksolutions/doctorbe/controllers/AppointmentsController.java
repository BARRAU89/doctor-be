package net.yorksolutions.doctorbe.controllers;

import net.yorksolutions.doctorbe.models.Appointment;
import net.yorksolutions.doctorbe.services.AppointmentsService;
import net.yorksolutions.doctorbe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentsController {

    private final AppointmentsService service;

    @Autowired
    public AppointmentsController(AppointmentsService service){
        this.service = service;
    };

    @PostMapping
    public void addNewAppointment(@RequestBody Appointment appointment) {
        try {
            service.addNewAppointment(appointment);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping
    public Iterable<Appointment> getAppointments(@RequestParam(required = false) Long patientId) {
        return service.getAppointments(patientId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            service.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void modifyAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        try {
            service.modifyAppointment(id, appointment);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
