package hiber.model;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Column
    private String model;
    @Column
    private int series;
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "carCar", cascade = CascadeType.ALL)
    private User user;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public int getId() {
        return id;
    }
}
