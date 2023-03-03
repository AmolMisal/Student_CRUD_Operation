package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepo;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	public StudentRepo stdrepo;

	@GetMapping
	public List<Student> getStudent() {
		return stdrepo.findAll();
	}
	
	@PostMapping
	public Student saveStudent(@RequestBody Student s){
		  return stdrepo.save(s); 
	}
	
	@DeleteMapping("{id}") 
	public void deleteStudent(@PathVariable("id") int id){
		stdrepo.deleteById(id); 
	}
	
	@PutMapping("/updateStudent") 
	public Student updateStudent(@RequestBody Student s){
		Optional<Student> std=stdrepo.findById(s.getId());
		Student st=std.get(); 
		st.setAge(s.getAge()); 
		st.setName(s.getName());
		st.setStandard(s.getStandard()); 
	 	return stdrepo.save(st); 
	}
}
