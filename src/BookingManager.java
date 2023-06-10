import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> listOfbookingManager;



    //METODA PRO VÝPOČET CENY ZA KAŽDOU OBJEDNÁVKU

    public void costPerOneReservation(){

        for(Booking booking : listOfbookingManager) {
            int numberOfNights = getNumberOfNightsPerReservation(booking);
            BigDecimal priceForReservation = booking.getRoom().priceForOneNight.multiply(BigDecimal.valueOf(numberOfNights));
            System.out.println(booking.getGuest() + " (pokoj " + booking.getRoom().getNumber() +
                    "): " + numberOfNights + " nocí od " + booking.getCheckInDate() + " za "
                    + priceForReservation + " Kč");
        }
    }


    //METODA- VÝPOČET JEDNO, DVOU A VÍCE DENNÍCH REZERVACÍ

    public void listOfReservationsDays(){

        int oneDayReservation = 0;
        int twoDayReservation = 0;
        int multiDayReservation = 0;

        for(Booking booking : listOfbookingManager){
            int numberOfNights = getNumberOfNightsPerReservation(booking);

            if(numberOfNights == 1){
                oneDayReservation++;
            } else if(numberOfNights == 2){
                twoDayReservation++;
            } else {
                multiDayReservation++;
            }
        }
        System.out.println("Jednodenní pobyty: " + oneDayReservation);
        System.out.println("Dvoudenní pobyty: " + twoDayReservation);
        System.out.println("Vícedenní pobyty: " + multiDayReservation);
    }


    //METODA PRO VÝPOČET NOCÍ NA JEDNU REZERVACI
    public int getNumberOfNightsPerReservation(Booking booking) {

        LocalDate checkInDate = booking.getCheckInDate();
        LocalDate checkOutDate = booking.getCheckOutDate();

        Period period = Period.between(checkInDate, checkOutDate);
        int numberOfNights = period.getDays();

        System.out.println("Reservation: " + checkInDate + " to "
                + checkOutDate + ", Počet nocí: " + numberOfNights);

        return numberOfNights;
    }

    //METODA PRO VYPSÁNÍ CELKOVEHO POČTU REZERVACÍ
    public int getNumberOfBookings(){
       return listOfbookingManager.size();
    }


    //METODA PRO VYPSÁNÍ WorkingREZERVACÍ
    public int getNumberOfWorkingBookings() {

        int numberOfWorkingBookings = 0;

        for (Booking booking : listOfbookingManager) {
            if (booking.getTypeOfVacation() == Booking.TypeOfVacation.WORK) {
                numberOfWorkingBookings++;
            }
        }
        return numberOfWorkingBookings;
    }

    public BookingManager() {
        listOfbookingManager = new ArrayList<>();
    }

    public BookingManager(List<Booking> listOfbookingManager) {
        this.listOfbookingManager = listOfbookingManager;
    }

    public void addOneBooking(Booking booking) {
        listOfbookingManager.add(booking);
    }

    public List<Booking> getListOfbookingManager() {
        return listOfbookingManager;
    }
}