package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  //?1 represents the first parameter passed to the method. If there are multiple parameters: ?2, ?3...
  @Query("SELECT s FROM Student s WHERE s.email = ?1")
  Optional<Student> findStudentByEmail(String email);

  @Query("SELECT s FROM Student s WHERE s.id = ?1")
  Optional<Student> findStudentById(long id);

}
