import java.math.BigDecimal;

public class Room {
    int number;
    int numberOfBed;
    boolean isThereBalcony;
    boolean isThereSeaView;
    BigDecimal priceForOneNight;

    //CONSTRUCTOR


    public Room(int number, int numberOfBed, boolean isThereBalcony, boolean isThereSeaView, BigDecimal priceForOneNight) {
        this.number = number;
        this.numberOfBed = numberOfBed;
        this.isThereBalcony = isThereBalcony;
        this.isThereSeaView = isThereSeaView;
        this.priceForOneNight = priceForOneNight;
    }

    //GETTER AND SETTER
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public boolean isThereBalcony() {
        return isThereBalcony;
    }

    public void setThereBalcony(boolean thereBalcony) {
        isThereBalcony = thereBalcony;
    }

    public boolean isThereSeaView() {
        return isThereSeaView;
    }

    public void setThereSeaView(boolean thereSeaView) {
        isThereSeaView = thereSeaView;
    }

    public BigDecimal getPriceForOneNight() {
        return priceForOneNight;
    }

    public void setPriceForOneNight(BigDecimal priceForOneNight) {
        this.priceForOneNight = priceForOneNight;
    }
}