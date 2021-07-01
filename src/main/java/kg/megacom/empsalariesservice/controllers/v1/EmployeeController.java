package kg.megacom.empsalariesservice.controllers.v1;

import kg.megacom.empsalariesservice.models.dto.EmployeeDto;
import kg.megacom.empsalariesservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto){
        return employeeService.save(employeeDto);
    }
}
