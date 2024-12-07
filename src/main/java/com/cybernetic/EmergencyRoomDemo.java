package com.cybernetic;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class EmergencyRoomDemo {
    public static void main(String[] args) throws InterruptedException {
        PatientComparator comparator = new PatientComparator();
        EmergencyRoom eRoom = new EmergencyRoom(comparator);

        eRoom.checkIn(new Patient("Mirabella Jones", LocalDate.of(1973, 7, 11)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("Ruth Mendez", LocalDate.of(1965, 1, 22)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("Melvin Ingram", LocalDate.of(1965, 1, 22)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("Tara Silva", LocalDate.of(1975, 5, 8)), Severity.EIGHT);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("Jeff Barnes", LocalDate.of(1968, 12, 19)), Severity.EIGHT);

        //add patients and print them
        Patient patient;
        while ((patient = eRoom.admit()) != null) {
            System.out.println(patient + " admitted\n");
        }
    }
}

