package kg.megacom.empsalariesservice.services;

import kg.megacom.empsalariesservice.models.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto);

    List<EmployeeDto> findAll();

    void delete(Long emp_id);
}
