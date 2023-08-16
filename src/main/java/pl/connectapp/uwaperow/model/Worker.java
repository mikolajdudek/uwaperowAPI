package pl.connectapp.uwaperow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Worker {
    @Id
    private Long id;
    private String name;
    private String special;
}
