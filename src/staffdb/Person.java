/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdb;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Person {
    private final int SECONDNAME = 0;
    private final int FIRSTNAME = 1;
    private final int SURNAME = 2;
    private final int DATEBIRTH = 3;

    private String secondName;
    private String firstName;
    private String surname;
    private String dateBirth; //data date
     
    public Person(ArrayList<String> dataPerson) throws PersonException  {
        if(dataPerson.get(SECONDNAME).length() == 0) throw new PersonException("Не заповнено поле 'Прізвище'", PersonException.NO_SECONDNAME);
        if(dataPerson.get(FIRSTNAME).length() == 0) throw new PersonException("Не заповнено поле 'Ім'я'", PersonException.NO_FIRSTNAME);
        if(dataPerson.get(SURNAME).length() == 0) throw new PersonException("Не заповнено поле 'По батькові'", PersonException.NO_SURNAME);
 
        secondName = dataPerson.get(SECONDNAME);
        firstName = dataPerson.get(FIRSTNAME);
        surname = dataPerson.get(SURNAME);
        dateBirth = dataPerson.get(DATEBIRTH);
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateBirth() {
        return dateBirth;
    }
    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        
        String str = secondName + "; " + firstName + "; " + surname + "; " + dateBirth;
        return str;
    }
}
