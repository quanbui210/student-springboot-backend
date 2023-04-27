package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.DECEMBER;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student nick = new Student(
              "Nick",
              LocalDate.of(2001, DECEMBER, 4),
              "nick@gmail.com"
      );
      Student alex = new Student(
              "Alex",
              LocalDate.of(1999, DECEMBER, 4),
              "alex@gmail.com"
      );
      repository.saveAll(
              List.of(nick, alex)
      );
    };
  }
}
