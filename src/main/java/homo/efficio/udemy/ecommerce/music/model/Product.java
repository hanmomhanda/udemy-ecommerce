package homo.efficio.udemy.ecommerce.music.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by hanmomhanda on 16. 2. 26.
 */
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @NotEmpty(message = "The product name must not be null.")
    private String productName;
    private String productCategory;
    private String productDescription;

    @Min(value = 0, message = "The product price must not be less than 0.")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less than 0.")
    private int unitInStock;
    private String productManufacturer;
    @Transient
    private MultipartFile productImage;
    private String productImageWebPath;
}
