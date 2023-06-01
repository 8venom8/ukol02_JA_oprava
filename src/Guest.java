import java.time.LocalDate;

public class Guest {

    String name;
    String lastName;
    LocalDate birthDate;

    //CONSTRUCTOR


    public Guest(String name, String lastName, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    //GETTER AND SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    //PŘEVEDENÍ NA STRING


    @Override
    public String toString() {
        return name + " " + lastName + " " + birthDate;
    }
}
