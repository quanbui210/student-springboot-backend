package com.example.demo.student;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service //for semantic, readability
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public Optional<Student> getStudentById(long id) {
    System.out.println(id);
    return studentRepository.findStudentById(id);
  }

  public void addNewStudent(Student student) {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      throw new IllegalStateException("email taken");
    }
    studentRepository.save(student);
    System.out.println(student);
  }

  public void deleteStudentById(Long id) {
    Optional<Student> studentOptional = studentRepository.findById(id);
    if (studentOptional.isPresent()) {
      studentRepository.delete(studentOptional.get());
    } else {
      throw new IllegalStateException("student not found");
    }
  }

  @Transactional
  public void updateStudent(Long id, String name, String email) {
    Optional<Student> student = studentRepository.findById(id);
    if (student.isPresent()) {
      if (name != null) {
        student.get().setName(name);
      }
      if (email != null) {
        student.get().setEmail(email);
      }
    } else {
      throw new IllegalStateException("Student not found");
    }
  }

}
