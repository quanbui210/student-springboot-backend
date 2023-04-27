package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @GetMapping(value = "/{id}")
  public Optional<Student> getStudentById(@PathVariable Long id) {
    return studentService.getStudentById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public void registerStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
  }

  @DeleteMapping(path = "/{id}")
  //@PathVariable is used to extract the value of a url template variable and bind into method parameter.
  public void deleteStudentById(@PathVariable("id") Long id) {
    studentService.deleteStudentById(id);
  }

  @PutMapping(path = "/{id}")
  public void updateStudent(
          @PathVariable("id") Long id,
          @RequestBody Student student)
  {
    studentService.updateStudent(id, student.getName(),student.getEmail() );
  }
}
