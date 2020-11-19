package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.InvalidDateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {

    Profile profile;

    @BeforeEach
    public void init() {
        profile = new Profile("Name");
    }

    @Test
    public void ReturnInvalidDateExceptionWhenDateOfBirthIsInFutur() {
        assertThrows(InvalidDateException.class, () -> {
            profile.setDateOfBirth(LocalDate.of(2030, 1, 1));
        });
    }

    @Test
    public void ReturnInvalidDateExceptionWhenDateOfBirthIsOneDayAfterToday() {
        assertThrows(InvalidDateException.class, () -> {
            profile.setDateOfBirth(LocalDate.now().plusDays(1));
        });
    }

    @Test
    public void ReturnNoInvalidDateExceptionWhenDateOfBirthIsNotInFutur() {
        profile.setDateOfBirth(LocalDate.of(2001, 1, 1));
        assertEquals(LocalDate.of(2001, 1, 1), profile.getDateOfBirth());
    }

    @Test
    public void ReturnNoInvalidDateExceptionWhenDateOfBirthIsEqualAsToday() {
        profile.setDateOfBirth(LocalDate.now());
        assertEquals(LocalDate.now(), profile.getDateOfBirth());
    }
}
