package com.example.demo.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmpRepository;
import com.example.demo.bean.EmpBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }


    public boolean addEmployee(EmpBean empBean) {
        try{
            if(Objects.nonNull(empBean.getId())){
                Optional<Employee> empDetails = empRepository.findById(empBean.getId());
                Employee getDetails = empDetails.get();
                getDetails.setId(empBean.getId());
                getDetails.setName(empBean.getName());
                getDetails.setLoc(empBean.getLoc());
                Employee updateData = empRepository.save(getDetails);
                return true;
            }else {
                Employee emp1 = new Employee();
                emp1.setName(empBean.getName());
                emp1.setLoc(empBean.getLoc());
                Employee saveEmployee = empRepository.save(emp1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Employee> findByName(String name) {
        return empRepository.findByName(name);
    }

    public Optional<Employee> findById(int id) {
        return empRepository.findById(id);
    }

    public Employee editEmployee(Employee employee){
        return empRepository.save(employee);

    }

    public int deleteById(int id) {
         empRepository.deleteById(id);
         return id;
    }
}
