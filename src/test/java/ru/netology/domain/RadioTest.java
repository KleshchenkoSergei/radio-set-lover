package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    //Test for Number of Stations
    @Test
    public void shouldSetNOSUnderLimit() {
        // NOS - Number of stations
        Radio radio = new Radio(-1);
        int actualNumberOfStations = radio.getCurrentNumberOfStations();
        assertEquals(10, actualNumberOfStations);
    }

    @Test
    public void shouldSetNOSZero() {
        // NOS - Number of stations
        Radio radio = new Radio(0);
        int actualNumberOfStations = radio.getCurrentNumberOfStations();
        assertEquals(10, actualNumberOfStations);
    }

    @Test
    public void shouldSetNOSTo1() {
        // NOS - Number of stations
        Radio radio = new Radio(1);
        int actualNumberOfStations = radio.getCurrentNumberOfStations();
        assertEquals(1, actualNumberOfStations);
    }

    @Test
    public void shouldSetNOSTo2() {
        // NOS - Number of stations
        Radio radio = new Radio(2);
        int actualNumberOfStations = radio.getCurrentNumberOfStations();
        assertEquals(2, actualNumberOfStations);
    }

    @Test
    public void shouldSetNOSToZero() {
        // The stations begin from 0
        Radio radio = new Radio(0, 13, 5);
        int actualNumberOfStations = radio.getCurrentNumberOfStations();
        assertEquals(10, actualNumberOfStations);
    }

    @Test
    public void shouldSetNOSLowerLimit() {
        // The stations begin from 0
        Radio radio = new Radio(-1, 13, 5);
        int actualNumberOfStations = radio.getCurrentNumberOfStations();
        assertEquals(10, actualNumberOfStations);
    }


    //Test for Stations
    @Test
    public void shouldSetStationUnderLimit() {
        // NOS - Number of stations
        Radio radio = new Radio(-1, 5);
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(0, actualCurrentStation);
    }

    @Test
    public void shouldSetStationToZero() {
        Radio radio = new Radio(0, 5);
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(0, actualCurrentStation);
    }

    @Test
    public void shouldSetStationTo1() {
        Radio radio = new Radio(1, 5);
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(1, actualCurrentStation);
    }

    @Test
    public void shouldSetStationUpperLimit() {
        Radio radio = new Radio(15, 5);
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(10, actualCurrentStation);
    }

    @Test
    public void shouldSetStationTo2() {
        Radio radio = new Radio(2, 5);
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(2, actualCurrentStation);
    }

    @Test
    public void shouldSetStationPrevUpLimit() {
        // The stations begin from 0
        Radio radio = new Radio(15, 13, 5);
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(13, actualCurrentStation);
    }

    @Test
    public void shouldSetStationUpLimit() {
        // The stations begin from 0
        Radio radio = new Radio(15, 14, 5);
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(14, actualCurrentStation);
    }

    // Station ++
    @Test
    public void shouldSetStationIncrease() {
        // NOS - Number of stations
        // The stations begin from 0
        Radio radio = new Radio(15, 13, 5);
        radio.next();
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(14, actualCurrentStation);
    }

    @Test
    public void shouldSetStationIncreaseOverLimit() {
        // NOS - Number of stations
        // The stations begin from 0
        Radio radio = new Radio(15, 14, 5);
        radio.next();
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(0, actualCurrentStation);
    }

    @Test
    public void shouldSetStationOverIncrease() {
        // NOS - Number of stations
        // The stations begin from 0
        Radio radio = new Radio(15, 16, 5);
        radio.next();
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(0, actualCurrentStation);
    }

    // Station --
    @Test
    public void shouldSetStationDecrease() {
        // NOS - Number of stations
        // The stations begin from 0
        Radio radio = new Radio(15, 14, 5);
        radio.prev();
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(13, actualCurrentStation);
    }

    @Test
    public void shouldSetStationDecreaseZero() {
        // NOS - Number of stations
        // The stations begin from 0
        Radio radio = new Radio(15, 0, 5);
        radio.prev();
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(14, actualCurrentStation);
    }

    @Test
    public void shouldSetStationUnderZeroDecrease() {
        // NOS - Number of stations
        // The stations begin from 0
        Radio radio = new Radio(15, -1, 5);
        radio.prev();
        int actualCurrentStation = radio.getCurrentStation();
        assertEquals(14, actualCurrentStation);
    }

    // IncreaseVolume
    @Test
    public void shouldSetVolumeIncrease() {
        // NOS - Number of stations
        Radio radio = new Radio(5, 50);
        radio.increaseVolume();
        int actualCurrentVolume = radio.getCurrentVolume();
        assertEquals(51, actualCurrentVolume);
    }

    @Test
    public void shouldSetVolumeIncreaseOver() {
        // NOS - Number of stations
        Radio radio = new Radio(5, 100);
        radio.increaseVolume();
        int actualCurrentVolume = radio.getCurrentVolume();
        assertEquals(100, actualCurrentVolume);
    }

    @Test
    public void shouldSetVolumeOverIncrease() {
        // NOS - Number of stations
        Radio radio = new Radio(5, 101);
        radio.increaseVolume();
        int actualCurrentVolume = radio.getCurrentVolume();
        assertEquals(100, actualCurrentVolume);
    }

    @Test
    public void shouldSetVolumeOverIncreaseNOS() {
        // NOS - Number of stations
        Radio radio = new Radio(10, 5, 101);
        radio.increaseVolume();
        int actualCurrentVolume = radio.getCurrentVolume();
        assertEquals(100, actualCurrentVolume);
    }

    // DecreaseVolume
    @Test
    public void shouldSetVolumeDecrease() {
        // NOS - Number of stations
        Radio radio = new Radio(5, 50);
        radio.decreaseVolume();
        int actualCurrentVolume = radio.getCurrentVolume();
        assertEquals(49, actualCurrentVolume);
    }

    @Test
    public void shouldSetVolumeDecreaseZero() {
        // NOS - Number of stations
        Radio radio = new Radio(5, 0);
        radio.decreaseVolume();
        int actualCurrentVolume = radio.getCurrentVolume();
        assertEquals(0, actualCurrentVolume);
    }

    @Test
    public void shouldSetVolumeDecreaseUnderZero() {
        // NOS - Number of stations
        Radio radio = new Radio(5, -1);
        radio.decreaseVolume();
        int actualCurrentVolume = radio.getCurrentVolume();
        assertEquals(0, actualCurrentVolume);
    }

    @Test
    public void shouldSetVolumeDecreaseUnderZeroNOS() {
        // NOS - Number of stations
        Radio radio = new Radio(10, 5, -1);
        radio.decreaseVolume();
        int actualCurrentVolume = radio.getCurrentVolume();
        assertEquals(0, actualCurrentVolume);
    }
}