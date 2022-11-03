package com.example.demo.Controller;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmpService;
import com.example.demo.bean.EmpBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = empService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Employee>> searchByName(@PathVariable String name) {
        List<Employee> emp = empService.findByName(name);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Optional<Employee> getById(@PathVariable Integer id) throws JsonProcessingException{
        try{
            Optional<Employee> obj = empService.findById(id);
            return obj;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/data")
    public Boolean saveEmployee(@RequestBody EmpBean empBean) {
        return empService.addEmployee(empBean);
    }

    @PutMapping("/edit")
    public Employee updateEmployee(@RequestBody Employee employee) {
         empService.editEmployee(employee);
         return employee;
    }

    @DeleteMapping("/dlt/{id}")
    public int deleteById(@PathVariable int id) throws JsonProcessingException{
        try{
            int obj = empService.deleteById(id);
            return obj;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
