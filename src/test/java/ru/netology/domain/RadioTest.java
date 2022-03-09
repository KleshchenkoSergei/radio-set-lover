package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(value = {"'Set Station -1, Volume -1', -1, 0, -1, 0",
            "'Set Station 0, Volume 0', 0, 0, 0, 0",
            "'Set Station 1, Volume 1', 1, 1, 1, 1",
            "'Set Station 8, Volume 9', 8, 8, 9, 9",
            "'Set Station 9, Volume 10', 9, 9, 10, 10",
            "'Set Station 10, Volume 11', 10, 0, 11, 0"})
    void setStationAndVolume(String testName, int newCurrentStation, int expectedStation, int newCurrentVolume, int expectedVolume) {
        Radio rad = new Radio();

        rad.setCurrentStation(newCurrentStation);
        int actualStation = rad.getCurrentStation();
        assertEquals(expectedStation, actualStation);

        rad.setCurrentVolume(newCurrentVolume);
        int actualVolume = rad.getCurrentVolume();
        assertEquals(expectedVolume, actualVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {"'Set Next station 5', 5, 6, 1, 1",
            "'Set Next station 9', 9, 0, 2, 2"})
    void setNextStation(String testName, int newCurrentStation, int expectedStation, int newCurrentVolume, int expectedVolume) {
        Radio rad = new Radio();

        rad.setCurrentStation(newCurrentStation);
        rad.next();
        int actualStation = rad.getCurrentStation();
        assertEquals(expectedStation, actualStation);

        rad.setCurrentVolume(newCurrentVolume);
        int actualVolume = rad.getCurrentVolume();
        assertEquals(expectedVolume, actualVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {"'Set Prev station 5', 5, 4, 3, 3",
            "'Set Prev station 0', 0, 9, 4, 4"})
    void setPrevStation(String testName, int newCurrentStation, int expectedStation, int newCurrentVolume, int expectedVolume) {
        Radio rad = new Radio();

        rad.setCurrentStation(newCurrentStation);
        rad.prev();
        int actualStation = rad.getCurrentStation();
        assertEquals(expectedStation, actualStation);

        rad.setCurrentVolume(newCurrentVolume);
        int actualVolume = rad.getCurrentVolume();
        assertEquals(expectedVolume, actualVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {"'Set Increase Volume 7', 5, 5, 7, 8",
            "'Set Increase Volume 10', 0, 0, 10, 10"})
    void setIncreaseVolume(String testName, int newCurrentStation, int expectedStation, int newCurrentVolume, int expectedVolume) {
        Radio rad = new Radio();

        rad.setCurrentStation(newCurrentStation);
        int actualStation = rad.getCurrentStation();
        assertEquals(expectedStation, actualStation);

        rad.setCurrentVolume(newCurrentVolume);
        rad.increaseVolume();
        int actualVolume = rad.getCurrentVolume();
        assertEquals(expectedVolume, actualVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {"'Set Decrease Volume 7', 7, 7, 7, 6",
            "'Set Decrease Volume 0', 8, 8, 0, 0"})
    void setDecreaseVolume(String testName, int newCurrentStation, int expectedStation, int newCurrentVolume, int expectedVolume) {
        Radio rad = new Radio();

        rad.setCurrentStation(newCurrentStation);
        int actualStation = rad.getCurrentStation();
        assertEquals(expectedStation, actualStation);

        rad.setCurrentVolume(newCurrentVolume);
        rad.decreaseVolume();
        int actualVolume = rad.getCurrentVolume();
        assertEquals(expectedVolume, actualVolume);
    }
}