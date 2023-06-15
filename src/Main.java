import java.math.BigDecimal;
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

        Booking booking1 = new Booking(Arrays.asList(adelaMalikova1993), firstRoom, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), Booking.TypeOfVacation.WORK);
        Booking booking2 = new Booking(Arrays.asList(adelaMalikova1993, janDvoracek1995), thirdRoom, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), Booking.TypeOfVacation.RECREATION);
        Booking booking3 = new Booking(Arrays.asList(janDvoracek1995));

        //DEKLARACE

        List<Booking> listOfBooking = new ArrayList<>();

        //PŘIDÁNÍ BOOKINGU NA LIST

        listOfBooking.add(booking1);
        listOfBooking.add(booking2);
        listOfBooking.add(booking3);

        //VYPSÁNÍ REZERVACÍ

        for (Booking booking : listOfBooking){
            System.out.println("Booking: " + booking.getDateOfVacation() + " Guests: " + booking.getGuest() + "Typ dovolené: " + booking.typeOfVacation);
        }




        //**************UKOL-03******************


        //VYTVOŘENÍ SEZNAMU listOFBookingManager
        List<Booking> listOfBookingManager = new ArrayList<>();

        //VYTVOŘENÍ OBJEKTU TŘÍDY BookingManager
        BookingManager bookingManager = new BookingManager();

        //HOSTI
        Guest karelDvorak1990 = new Guest("Karel", "Dvořák", LocalDate.of(1990,5,15));
        Guest karelDvorak1979 = new Guest("Karel", "Dvořák", LocalDate.of(1997, 1, 3));
        Guest ABC_relax = new Guest("ABC Relax");
        Guest alenaKrasova2000 = new Guest("Alena", "Krásová", LocalDate.of(2000, 3, 13));

        //REZERVACE
        Booking bookingKarelDvorak1990 = new Booking(Arrays.asList(karelDvorak1990), thirdRoom, LocalDate.of(2023, 6, 3), LocalDate.of(2023, 6, 7), Booking.TypeOfVacation.WORK);
        Booking bookingKarelDvorak1979 = new Booking(Arrays.asList(karelDvorak1979), secondRoom, LocalDate.of(2023, 8, 18), LocalDate.of(2023, 8, 21), Booking.TypeOfVacation.RECREATION);


        //PŘIDANI HOSTU DO SEZNAMU
        bookingManager.addOneBooking(bookingKarelDvorak1990);


        //CYKLUS REZERVACI PRO alenaKrasova2000
        for (int i = 0; i < 5; i++) {
            LocalDate startDate = LocalDate.of(2023, 6, 1);
            LocalDate currentDate = startDate.plusDays(1);
            Booking bookingAlenaKrasova2000 = new Booking(Arrays.asList(alenaKrasova2000), firstRoom, startDate, currentDate, Booking.TypeOfVacation.WORK);
            bookingManager.addOneBooking(bookingAlenaKrasova2000);
            startDate = currentDate.plusDays(1);
        }


        //CYKLUS REZERVACI PRO ABS_relax
        for (int i = 0; i < 30; i++) {

            LocalDate startDate = LocalDate.of(2023, 6, 1);
            LocalDate endDate = startDate.plusDays(1);
            Booking bookingABCrelax = new Booking(Arrays.asList(ABC_relax), thirdRoom, startDate, endDate, Booking.TypeOfVacation.WORK);
            bookingManager.addOneBooking(bookingABCrelax);

            startDate = endDate.plusDays(1);
        }


        //CYKLUS REZERVACI PRO ABBC_relax

        LocalDate startDate = LocalDate.of(2023, 8, 1);
        for (int i = 0; i < 4; i++) {


            LocalDate endDate = startDate.plusDays(2);
            Booking bookingABCrelax = new Booking(Arrays.asList(ABC_relax), secondRoom, startDate, endDate, Booking.TypeOfVacation.WORK);
            bookingManager.addOneBooking(bookingABCrelax);

            startDate = startDate.plusDays(7);
        }



        //VÝPIS REZERVACÍ

        for (Booking booking : bookingManager.getListOfbookings()) {
            System.out.println("Booking: " + booking.getDateOfVacation() +
                    " Guests: " + booking.getGuest() + "Typ dovolené: "
                    + booking.typeOfVacation);
        }



        //VOLÁNÍ METODY PRO ZJIŠTĚNÍ POČTU PRACOVNÍCH REZERVACÍ

        int numberOfWorkingBookings = bookingManager.getNumberOfWorkingBookings();
        System.out.println("Počet pracovních rezervací: " + numberOfWorkingBookings);



        //VYPSÁNÍ VŠECH REZERVACÍ VE FORTMÁTU- pokulhává to ve výpisu boolean hodnot

        for (Booking booking : bookingManager.getListOfbookings()){
            System.out.println(booking.getCheckInDate() + " až " +
                    booking.getCheckOutDate() + ": " + booking.getGuest() +
                    " (" + booking.getGuest().get(0).getBirthDate() +
                    ") [" + booking.getRoom().getNumberOfBed() + " , "
                    + booking.getRoom().isThereBalconyToString() + " ]");
        }


        //PRŮMĚRNÝ POČET REZERVACÍ NA JEDNU OSOBU

        int totalGuest = 0;
        int totalReservation = bookingManager.getListOfbookings().size();

        for (Booking booking : bookingManager.getListOfbookings()){
            totalGuest = totalGuest + booking.getGuest().size();
            totalReservation++;
        }

        double averageGuests = totalGuest / (double) totalReservation; //(double) protože ostatní bylo int
        System.out.println("Průměr rezervací na osobu je: " + averageGuests);



        //PRVNÍCH 8 HOSTU S REKREACI

        int listOfCurrentReservation = 0;
        System.out.println("HOSTÉ S REKREAČNÍM POBYTEM: ");
        for (Booking booking : listOfBooking){
            if (booking.getTypeOfVacation().toString().equals("RECREATION")){
                System.out.println(booking.getGuest());
                listOfCurrentReservation++;

                if (listOfCurrentReservation == 8){
                    break;
                }
            }
        }

        //VÝPOČET NOCÍ NA JEDNU REZERVACI

        for (Booking booking : bookingManager.getListOfbookings()) {

            bookingManager.getNumberOfNightsPerReservation(booking);
        }


        //VÝPIS JEDNO, DVOU, VÍCE DENNÍCH REZRAVCÍ

        //List<Booking> bookings = new ArrayList<>();
        bookingManager.listOfReservationsDays();

        //VÝPIS CEN ZA KAŽDOU OBJEDNÁVKU

        bookingManager.costPerOneReservation();
    }
}