package com.example.demo.service;


import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository repository;

    public Student create(StudentDTO dto){
        Student s = new Student();
        s.setName(dto.getName());

        log.info("Creating student: {}",dto.getName());
        return repository.save(s);
    }

    public List<Student> getAll(){
        return repository.findAll();
    }

    public Student update(Long id,StudentDTO dto){
        Student s = repository.findById(id)
                .orElseThrow(()->new RuntimeException("Not Found"));
        s.setName(dto.getName());
        log.info("Update student: {}",id);
        return repository.save(s);
    }
    public void delete(Long id){
        repository.deleteById(id);
        log.info("Deleted student {}",id);
    }

}
