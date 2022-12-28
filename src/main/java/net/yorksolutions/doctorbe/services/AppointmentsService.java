package net.yorksolutions.doctorbe.services;
import net.yorksolutions.doctorbe.models.Appointment;
import net.yorksolutions.doctorbe.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AppointmentsService {

    AppointmentRepository appointmentRepository;

    public AppointmentsService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    private Long nextAppointmentId = 0L;
    //private ArrayList<Appointment> appointments = new ArrayList<>(); //by commenting this line out, we are no longer storing data in memory

    public void addNewAppointment( Appointment appointment) {
        this.appointmentRepository.save(appointment);

    }

    public Iterable<Appointment> getAppointments(Long patientId) {
//        if (patientId != null) {
//            final var matching = new ArrayList<Appointment>();
//            for (Appointment appointment : appointments)
//                if (patientId.equals(appointment.patientId)) { //this .equals will be a valid operation because we have checked that patientId isn't null some lines above.
//                    matching.add(appointment); //this will return all appointments that matches the patientId
//                }
//            return matching;
//        }
//        if (doctorId != null) {
//            final var matching = new ArrayList<Appointment>();
//            for (Appointment appointment : appointments)
//                if (doctorId.equals(appointment.doctorId)) {
//                    matching.add(appointment);
//                }
//            return matching;
//       }
        //this.http.get<Appointment[]>(`http://localhost:3000/appointments`)
        //       return appointments;

        if (patientId != null){
            Iterable<Appointment> appointmentList = this.appointmentRepository.findAllByPatientId(patientId);
            return appointmentList;
        }
        return this.appointmentRepository.findAll();

    }

    public void deleteById(Long id) throws Exception {
//        for (var appointment : appointments) {
//            if (appointment.id.equals(id)) {
//                appointments.remove(appointment);
//                return;
//            }
//        }
        Optional<Appointment> appointmentOpt = this.appointmentRepository.findById(id);
        if (appointmentOpt.isEmpty()){
            throw new Exception();
        }
        this.appointmentRepository.deleteById(id);
    }


    public void modifyAppointment( Long id, Appointment updatedAppointment) throws Exception {
        Optional<Appointment> appointmentOpt = this.appointmentRepository.findById(id);
        if (appointmentOpt.isEmpty()){
            throw new Exception();
        }
        Appointment appointment = appointmentOpt.get(); // the get allows us to access whatever the Optional contains
        appointment.date = updatedAppointment.date;
        appointment.slot = updatedAppointment.slot;
        //appointment.patientId = updatedAppointment.patientId;
        //we don't update the id because that could create a duplicate in the db
        //appointment.setSlot(updatedAppointment.getSlot()); if we were using getters and setters
        appointmentRepository.save(appointment);

//        for (var existingAppointment: appointments){
//            if (id.equals(existingAppointment.id)){
//                appointments.remove(existingAppointment);
//                appointments.add(appointment);
//                return;
//            }
//        }
//        throw new Exception();
    }
}
