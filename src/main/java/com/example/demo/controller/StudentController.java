package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody StudentDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }
    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,@Valid @RequestBody StudentDTO dto){
        return service.update(id,dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
