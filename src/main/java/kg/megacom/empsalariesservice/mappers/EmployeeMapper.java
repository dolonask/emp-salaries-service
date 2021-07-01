package kg.megacom.empsalariesservice.mappers;

import kg.megacom.empsalariesservice.models.Employee;
import kg.megacom.empsalariesservice.models.dto.EmployeeDto;

public interface EmployeeMapper {

    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee, double salary);
}
