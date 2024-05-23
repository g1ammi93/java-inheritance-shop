package exercises.inheritance;

public class Smartphone extends Product{

    //attributi
    private String imeiCode;
    private int ram;


    //costruttore
    public Smartphone(int vat, String name, String description, double price, String imeiCode, int ram) {
        super(vat, name, description, price);
        this.imeiCode = imeiCode;
        this.ram = ram;
    }

    //metodi

    @Override
    public String toString() {
        return "Smartphone{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                ", imeiCode='" + imeiCode + '\'' +
                ", ram=" + ram +
                '}';
    }


    @Override
    public double getDiscountedPrice(boolean hasFidelityCard) {
        double discountedPrice = 0;
        if (hasFidelityCard) {
            if (ram < 32) {
                discountedPrice = (price * 0.05);
            } else {
                discountedPrice = (price * 0.02);
            }
        }

        return getVatPrice() - discountedPrice;
    }
    //getter e setter

    public String getImeiCode() {
        return imeiCode;
    }

    public void setImeiCode(String imeiCode) {
        this.imeiCode = imeiCode;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

}