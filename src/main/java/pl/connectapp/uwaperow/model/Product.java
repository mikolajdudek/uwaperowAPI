package pl.connectapp.uwaperow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "vwTowar") // Ustal nazwę tabeli i schemat
public class Product {
    @Id
    private Long tw_Id;
    private Long st_MagId;
    private String tw_Symbol;
    private String tw_Nazwa;
    private double st_Stan;
    private double tc_CenaBrutto1;
}



