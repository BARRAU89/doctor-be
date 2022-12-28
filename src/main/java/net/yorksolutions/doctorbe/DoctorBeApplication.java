package net.yorksolutions.doctorbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorBeApplication {

    // Java needs a dedicated place to 'start' the program
    // It does not just start at the top of a file
    // Java is a compiled language

    public static void main(String[] args) {
        SpringApplication.run(DoctorBeApplication.class, args);
    }

}
