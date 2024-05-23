package exercises.inheritance;

public class Television extends Product{

    //attributi
    private boolean isItSmart;
    private int dimensions;


    //costruttore

    public Television(int vat, String name, String description, double price, boolean isItSmart, int dimensions) {
        super(vat, name, description, price);
        this.isItSmart = isItSmart;
        this.dimensions = dimensions;
    }

    //metodi

    @Override
    public String toString() {
        return "Television{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                ", isItSmart=" + isItSmart +
                ", dimensions='" + dimensions + '\'' +
                '}';
    }

    @Override
    public double getDiscountedPrice(boolean hasFidelityCard) {
        double discountedPrice = 0;
        if (hasFidelityCard) {
            if (!isItSmart) {
                discountedPrice = (price * 0.1);
            } else {
                discountedPrice = (price * 0.02);
            }
        }
        return getVatPrice() - discountedPrice;
    }

    //getter e setter

    public boolean isItSmart() {
        return isItSmart;
    }

    public void setItSmart(boolean itSmart) {
        isItSmart = itSmart;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }
}
