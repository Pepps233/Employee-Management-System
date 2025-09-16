package dev.jayyu.ems_backend.service.impl;

import dev.jayyu.ems_backend.dto.EmployeeDto;
import dev.jayyu.ems_backend.entity.Employee;
import dev.jayyu.ems_backend.exception.ResourceNotFoundException;
import dev.jayyu.ems_backend.mapper.EmployeeMapper;
import dev.jayyu.ems_backend.repository.EmployeeRepository;
import dev.jayyu.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    /** constructor injection via @AllArgsConstructor */
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee " + employeeId + " does not exist")
                );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        /**
         * stream (>= java 8) allows operations (like mapping) to be preformed on lists
         * collectors.toList() collects the mapped list
         */
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto newEmployeeInfo) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee " + employeeId + " does not exist")
                );

        employee.setFirstName(newEmployeeInfo.getFirstName());
        employee.setLastName(newEmployeeInfo.getLastName());
        employee.setEmail(newEmployeeInfo.getEmail());

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee " + employeeId + " does not exist")
                );
        employeeRepository.delete(employee);
    }
}
