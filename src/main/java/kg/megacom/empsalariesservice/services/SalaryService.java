package kg.megacom.empsalariesservice.services;

import kg.megacom.empsalariesservice.models.Employee;
import kg.megacom.empsalariesservice.models.dto.EmployeeDto;

public interface SalaryService {

    void setSalaryForEmployee(double salary, Employee employee);
}
