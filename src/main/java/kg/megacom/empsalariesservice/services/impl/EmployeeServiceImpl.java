package kg.megacom.empsalariesservice.services.impl;

import kg.megacom.empsalariesservice.dao.EmployeeRepo;
import kg.megacom.empsalariesservice.mappers.EmployeeMapper;
import kg.megacom.empsalariesservice.models.Employee;
import kg.megacom.empsalariesservice.models.dto.EmployeeDto;
import kg.megacom.empsalariesservice.services.EmployeeService;
import kg.megacom.empsalariesservice.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private SalaryService salaryService;
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEmployee(employeeDto);
        employee = employeeRepo.save(employee);

        salaryService.setSalaryForEmployee(employeeDto.getSalary(), employee);

        return employeeMapper.toEmployeeDto(employee, employeeDto.getSalary());
        
    }
}
