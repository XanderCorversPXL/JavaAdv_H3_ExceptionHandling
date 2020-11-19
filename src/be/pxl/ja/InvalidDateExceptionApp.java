package be.pxl.ja;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.time.LocalDate;

public class InvalidDateExceptionApp {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2001, 10, 1);
        throw new InvalidDateException(localDate, "geboorteDatum", "geboorteDatum niet toegestaan!");
    }
}
