package pl.connectapp.uwaperow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.connectapp.uwaperow.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.st_MagId = 2 and p.st_Stan > 0 and p.tw_Nazwa <> '1' and p.tc_CenaBrutto1 > 0")
    List<Product> getProductsBySt_MagIdAndSt_Stan();
}
