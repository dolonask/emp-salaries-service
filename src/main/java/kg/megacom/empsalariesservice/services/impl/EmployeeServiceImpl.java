package kg.megacom.empsalariesservice.services.impl;

import kg.megacom.empsalariesservice.dao.EmployeeRepo;
import kg.megacom.empsalariesservice.exceptions.EmployeeNotFound;
import kg.megacom.empsalariesservice.mappers.EmployeeMapper;
import kg.megacom.empsalariesservice.models.Employee;
import kg.megacom.empsalariesservice.models.dto.EmployeeDto;
import kg.megacom.empsalariesservice.services.EmployeeService;
import kg.megacom.empsalariesservice.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {

        Employee employee = employeeRepo.findById(employeeDto.getId()).orElseThrow(()-> new EmployeeNotFound("Сотрудник не найден!"));

        employee = employeeMapper.toEmployee(employeeDto);

        salaryService.setSalaryForEmployee(employeeDto.getSalary(), employee);

        return employeeMapper.toEmployeeDto(employee, employeeDto.getSalary());
    }

    @Override
    public List<EmployeeDto> findAll() {

        List<Employee> employees = employeeRepo.findAll();

        List<EmployeeDto> employeeDtos = employees
                .stream()
                .map(x-> employeeMapper.toEmployeeDto(x, salaryService.findCurrentSalary(x)))
                .collect(Collectors.toList());

        return employeeDtos;
    }

    @Override
    public void delete(Long emp_id) {
        Employee employee = employeeRepo.findById(emp_id).orElseThrow(()-> new EmployeeNotFound("Сотрудник не найден!"));
        employee.setActive(false);
        employeeRepo.save(employee);

    }
}
