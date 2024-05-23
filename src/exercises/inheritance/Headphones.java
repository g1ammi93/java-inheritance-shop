package exercises.inheritance;

public class Headphones extends Product{

    //attributi
    private String color;
    private boolean isItWireless;


    //costruttore
    public Headphones(int vat, String name, String description, double price, String color, boolean isItWireless) {
        super(vat, name, description, price);
        this.color = color;
        this.isItWireless = isItWireless;
    }

    //metodi

    @Override
    public String toString() {
        return "Headphones{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                ", color='" + color + '\'' +
                ", isItWireless=" + isItWireless +
                '}';
    }


    @Override
    public double getDiscountedPrice(boolean hasFidelityCard) {
        double discountedPrice = 0;
        if (hasFidelityCard) {
            if (!isItWireless) {
                discountedPrice = (price * 0.07);
            } else {
                discountedPrice = (price * 0.02);
            }
        }

        return getVatPrice() - discountedPrice;
    }

    //getter e setter

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isItWireless() {
        return isItWireless;
    }

    public void setItWireless(boolean itWireless) {
        isItWireless = itWireless;
    }
}
