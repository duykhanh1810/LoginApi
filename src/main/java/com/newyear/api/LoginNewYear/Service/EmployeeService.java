package com.newyear.api.LoginNewYear.Service;

import com.newyear.api.LoginNewYear.Dtos.EmployeeDto;
import com.newyear.api.LoginNewYear.Dtos.LoginDto;
import com.newyear.api.LoginNewYear.payload.message.LoginMessage;

public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDto);
    LoginMessage loginEmployee(LoginDto loginDTO);
}
