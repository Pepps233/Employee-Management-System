package dev.jayyu.ems_backend.controller;

import dev.jayyu.ems_backend.dto.EmployeeDto;
import dev.jayyu.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    /** add employee RESTful API */
    @PostMapping("/insert")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.OK);
    }

    /** get employee RESTful API */
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    /** get all employees RESTful API */
    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtoList =  employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
    }

    /** update employee by id RESTful API */
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto newEmployeeInfo) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, newEmployeeInfo);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    /** delete employee by id RESTful API */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeToDelete = employeeService.getEmployeeById(employeeId);
        String employeeFirstName = employeeToDelete.getFirstName();
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee: " + employeeFirstName + " is removed", HttpStatus.OK);
    }
}
