package pl.edu.knbit.bitjava.shop.domain.client;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Embeddable
public class Address {

    @NotNull
    private String city;

    @NotNull
    private String street;

    @Positive
    private Long streetNumber;

    @Positive
    private Long flatNumber;

}
