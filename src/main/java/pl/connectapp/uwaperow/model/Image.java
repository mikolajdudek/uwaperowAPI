package pl.connectapp.uwaperow.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.cglib.proxy.Mixin;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ImageEntity")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true,updatable = false, nullable = false)
    private Long id;
    @Column(name = "imageurl")
    private String imageUrl;

}
