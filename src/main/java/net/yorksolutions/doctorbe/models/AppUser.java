package net.yorksolutions.doctorbe.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AppUser { //here we defined the User class as in the FE we defined the class User in the data folder.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String username;
    public String password;
    public boolean doctor;

    @OneToMany
    public List<Appointment> appointments;


    public AppUser(Long id, String username, String password, boolean doctor){
        this.id = id;
        this.username = username;
        this.password = password;
        this.doctor = doctor;
    }

    public AppUser() {
    }

////////////
    @OneToMany
    public  List <Foo> fooList;


}
