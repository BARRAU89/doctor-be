package net.yorksolutions.doctorbe.repositories;

import net.yorksolutions.doctorbe.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository <Appointment, Long>{
    Iterable<Appointment> findAllByPatientId(Long id);

}
