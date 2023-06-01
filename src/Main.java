import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //TVOŘENÍ HOSTŮ

        Guest adelaMalikova1993 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest janDvoracek1995 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5 , 5));

        System.out.println(adelaMalikova1993);
        System.out.println(janDvoracek1995);

        //TVOŘENÍ POKOJŮ

        Room firstRoom = new Room(1, 1, true, true, BigDecimal.valueOf(1000));
        Room secondRoom = new Room(2, 1, true, true, BigDecimal.valueOf(1000));
        Room thirdRoom = new Room(3, 3, false, true, BigDecimal.valueOf(2400));

        //ŘÍPRAVA REZERVACÍ

        Booking booking1 = new Booking(Arrays.asList(adelaMalikova1993), firstRoom, "19.7.2021", "26.7.2021", Booking.TypeOfVacation.WORK);
        Booking booking2 = new Booking(Arrays.asList(adelaMalikova1993, janDvoracek1995), thirdRoom, "1.9.2021", "14.9.2021", Booking.TypeOfVacation.RECREATION);

        //DEKLARACE

        List<Booking> listOfBookings = new ArrayList<>();

        //PŘIDÁNÍ BOOKINGU NA LIST

        listOfBookings.add(booking1);
        listOfBookings.add(booking2);

        //VYPSÁNÍ REZERVACÍ

        for (Booking booking : listOfBookings){
            System.out.println("Booking: " + booking.getDateOfVacation() + " Guests: " + booking.getGuest() + "Typ dovolené: " + booking.typeOfVacation);
        }
    }
}