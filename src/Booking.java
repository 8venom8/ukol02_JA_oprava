import java.util.List;

public class Booking {
    List<Guest> guest; //k ukládání hostů k rezervaci
    Room room;
    String checkInDay;
    String checkOutDay;
    String typeOfVacation;

    //CONSTRUCTOR
    public Booking(List<Guest> guest, Room room, String checkInDay, String checkOutDay, String typeOfVacation) {
        this.guest = guest;
        this.room = room;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.typeOfVacation = typeOfVacation;
    }

    //GETTER AND SETTER
    public List<Guest> getGuest() {
        return guest;
    }

    public String getDateOfVacation(){
        return checkInDay + " - " + checkOutDay;
    }

    public void setGuest(List<Guest> guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(String checkInDay) {
        this.checkInDay = checkInDay;
    }

    public String getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(String checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public String getTypeOfVacation() {
        return typeOfVacation;
    }

    public void setTypeOfVacation(String typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }
}
