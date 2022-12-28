package net.yorksolutions.doctorbe.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    //public Long patientId; //commented out so @OneToOne relationship could be deployed
    public Date date;
    public int slot;

    @OneToOne
    public AppUser patient;

    @OneToOne
    public AppUser doctor;

}
