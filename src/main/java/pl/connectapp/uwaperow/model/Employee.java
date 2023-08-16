package pl.connectapp.uwaperow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String special;

    @OneToMany
    @JoinColumn(name = "employee_id")
    List<Worker> worker;
}
