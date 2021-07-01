package kg.megacom.empsalariesservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue
    private Long id;

    private double salary;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    


}
