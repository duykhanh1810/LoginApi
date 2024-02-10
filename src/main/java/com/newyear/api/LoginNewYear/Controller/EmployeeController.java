package com.newyear.api.LoginNewYear.Controller;

import com.newyear.api.LoginNewYear.Dtos.EmployeeDto;
import com.newyear.api.LoginNewYear.Dtos.LoginDto;
import com.newyear.api.LoginNewYear.Service.EmployeeService;
import com.newyear.api.LoginNewYear.payload.message.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/register")
    public String register(@RequestBody EmployeeDto employeeDTO){
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        LoginMessage loginMessage = employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginMessage);
    }
}
