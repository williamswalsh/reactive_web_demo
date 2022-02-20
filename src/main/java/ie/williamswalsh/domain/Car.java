package ie.williamswalsh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String registration;
    private CarBrand brand;
    private String model;
    private int year;
}
