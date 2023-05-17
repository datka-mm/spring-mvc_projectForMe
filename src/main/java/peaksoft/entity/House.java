package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @Id
    @GeneratedValue(generator = "house_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "house_gen", sequenceName = "house_seq", allocationSize = 1)
    private Long id;
    private String imageLink;
    private String description;
    private String address;
    private int price;
    private boolean isSale = false;

    public House(String imageLink, String description, String address, int price, boolean isSale) {
        this.imageLink = imageLink;
        this.description = description;
        this.address = address;
        this.price = price;
        this.isSale = isSale;
    }
}
