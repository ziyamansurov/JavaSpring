package ownspring.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long address_ID;

    @Column
    private String zipcode;
    @ManyToOne
    private City city;

}
