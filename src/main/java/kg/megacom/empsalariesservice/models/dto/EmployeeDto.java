package kg.megacom.empsalariesservice.models.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;
    private boolean active;
    private double salary;

}
