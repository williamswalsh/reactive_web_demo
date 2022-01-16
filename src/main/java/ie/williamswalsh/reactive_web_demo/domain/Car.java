package ie.williamswalsh.reactive_web_demo.domain;

public class Car {
    private String brand;
    private String model;
    private int year;
    private Long id;

    public Car(String brand, String model, int year, Long id) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.id = id;
    }

    private Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
