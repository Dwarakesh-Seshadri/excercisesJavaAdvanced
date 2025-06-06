package be.abis.exercise.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TestDateTime {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate calculated = now.plusYears(3).plusMonths(2).plusDays(15);
        System.out.println(calculated.format(dtf));
        LocalDate myBirthDate = LocalDate.of(1987,03,03);
        Locale locLn = new Locale("ta");
        System.out.println("I was born on : " + myBirthDate.format(DateTimeFormatter.ofPattern("EEEE",locLn)));
        long daysOld = ChronoUnit.DAYS.between(myBirthDate,now);
        System.out.println(daysOld);

    }

}
