package com.newyear.api.LoginNewYear.Service.Impl;

import com.newyear.api.LoginNewYear.Dtos.EmployeeDto;
import com.newyear.api.LoginNewYear.Dtos.LoginDto;
import com.newyear.api.LoginNewYear.Entity.Employee;
import com.newyear.api.LoginNewYear.Repository.EmployeeRepository;
import com.newyear.api.LoginNewYear.Service.EmployeeService;
import com.newyear.api.LoginNewYear.payload.message.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );
        employeeRepository.save(employee);
        return employee.getName();
    }

    @Override
    public LoginMessage loginEmployee(LoginDto loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepository.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }
    }
}
