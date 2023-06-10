import java.time.LocalDate;
import java.util.List;

public class Booking {
    List<Guest> guest; //k ukládání hostů k rezervaci
    Room room;
    LocalDate checkInDate;
    LocalDate checkOutDate;

    TypeOfVacation typeOfVacation;

    public enum TypeOfVacation {
        WORK,
        RECREATION
    }



    //CONSTRUCTOR
    public Booking(List<Guest> guest, Room room, LocalDate checkInDay, LocalDate checkOutDay, TypeOfVacation typeOfVacation) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDay;
        this.checkOutDate = checkOutDay;
        this.typeOfVacation = typeOfVacation;
    }

    public Booking(List<Guest> guest) {
        this.guest = guest;
        LocalDate currentDate = LocalDate.now();
        checkInDate = currentDate;
        this.checkOutDate = currentDate.plusDays(6);
        this.typeOfVacation = TypeOfVacation.RECREATION;
    }

    //GETTER AND SETTER
    public List<Guest> getGuest() {
        return guest;
    }

    public String getDateOfVacation(){
        return checkInDate + " - " + checkOutDate;
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

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public TypeOfVacation getTypeOfVacation() {
        return typeOfVacation;
    }

    public void setTypeOfVacation(TypeOfVacation typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }

    @Override
    public String toString() {
        return "typeOfVacation: " + typeOfVacation;
    }
}
