package exercises.inheritance;

import java.util.Objects;
import java.util.Random;

public class Product {

    //attributi
    protected int code;
    protected String name;
    protected String description;
    protected double price;
    protected int vat;

    //costruttore
    public Product(int vat, String name, String description, double price) {
        code = getRandom();
        this.vat = (vat > 0) ? vat : 22;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //metodi

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                '}';
    }

    public double getVatPrice() {
        double vatPrice = ((price * vat) / 100) + price;
        return Math.round(vatPrice * 100.0) / 100.0;
    }

    public double getDiscountedPrice(boolean hasFidelityCard) {
        double discountedPrice = 0;
        if (hasFidelityCard) {
            discountedPrice = (price * 0.02);
        }
        return getVatPrice() - discountedPrice;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(1, 999999);
    }

    //getter e setter


    public String getName() {
        return getCode() + "-" + name;
    }

    public void setName(String name) {
        if (Objects.equals(name, "")) {
            this.name = "";
        } else {
            this.name = name;
        }
    }

    public String getCode() {
        return String.format("%06d", code);

    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }
}