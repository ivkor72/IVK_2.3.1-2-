package model;

public class Car {

    private String carModel;
    private String carSeries;
    private String carColor;

    public Car(String carModel, String carSeries, String carColor) {
        this.carModel = carModel;
        this.carSeries = carSeries;
        this.carColor = carColor;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public String getCarSeries() {
        return carSeries;
    }
    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }
    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    @Override
    public String toString() {
        return
                "carModel='" + carModel + '\'' +
                ", carSeries='" + carSeries + '\'' +
                ", carColor='" + carColor + '\'' ;
    }
}
