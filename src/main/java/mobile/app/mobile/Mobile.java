package mobile.app.mobile;

public class Mobile {
    private String brand;
    private String model;
    private double price;
    private int ram;

    public Mobile(String brand, String model, double price, int ram) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.ram = ram;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                '}';
    }
}
