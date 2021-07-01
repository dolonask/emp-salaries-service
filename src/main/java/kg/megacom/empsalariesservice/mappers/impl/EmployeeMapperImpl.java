package kg.megacom.empsalariesservice.mappers.impl;

import kg.megacom.empsalariesservice.mappers.EmployeeMapper;
import kg.megacom.empsalariesservice.models.Employee;
import kg.megacom.empsalariesservice.models.dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public Employee toEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setActive(employeeDto.isActive());
        return employee;
    }

    @Override
    public EmployeeDto toEmployeeDto(Employee employee, double salary) {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setActive(employee.isActive());
        employeeDto.setSalary(salary);
        return employeeDto;
    }
}
