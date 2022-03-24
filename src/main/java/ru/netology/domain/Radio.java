package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Data

public class Radio {

    private int currentStation;
    private int currentVolume;
    private int currentNumberOfStations = 10;

    public Radio(int currentNumberOfStations) {
        if (currentNumberOfStations > 0) {
            this.currentNumberOfStations = currentNumberOfStations;
        }
    }

    public Radio(int currentStation, int currentVolume) {
        if ((currentStation >= 0) & (currentStation < currentNumberOfStations)) {
            this.currentStation = currentStation;
        }
        if ((currentVolume >= 0) & (currentVolume <= 100)) {
            this.currentVolume = currentVolume;
        }
        if (currentStation > currentNumberOfStations) {
            this.currentStation = currentNumberOfStations;
        }
        if (currentVolume < 0) {
            this.currentVolume = 0;
        }
        if (currentVolume > 100) {
            this.currentVolume = 100;
        }
    }

    public Radio(int currentNumberOfStations, int currentStation, int currentVolume) {
        if (currentNumberOfStations > 0) {
            this.currentNumberOfStations = currentNumberOfStations;
        }
        if ((currentStation >= 0) & (currentStation < this.currentNumberOfStations)) {
            this.currentStation = currentStation;
        }
        if (currentStation >= this.currentNumberOfStations) {
            this.currentStation = this.currentNumberOfStations - 1;
        }
        if ((currentVolume >= 0) & (currentVolume <= 100)) {
            this.currentVolume = currentVolume;
        }
        if (currentVolume < 0) {
            this.currentVolume = 0;
        }
        if (currentVolume > 100) {
            this.currentVolume = 100;
        }
    }

//    public int getCurrentNumberOfStations() {
//        return currentNumberOfStations;
//    }

//    public int getCurrentStation() {
//        return currentStation;
//    }

//    public void setCurrentStation(int currentStation) {
//        this.currentStation = currentStation;
//    }

    public void next() {
        setCurrentStation(currentStation);
        if (currentStation < (currentNumberOfStations -1)) {
            currentStation++;
        }else {
            currentStation = 0;
        }
    }

    public void prev() {
        setCurrentStation(currentStation);
        if (currentStation < 1) {
            currentStation = currentNumberOfStations - 1;
        }else {
            currentStation --;
        }
    }

//    public int getCurrentVolume() {
//        return currentVolume;
//    }

//    public void setCurrentVolume(int currentVolume) {
//        this.currentVolume = currentVolume;
//    }

    public void increaseVolume() {
        setCurrentVolume(currentVolume);
        if (currentVolume < 100) {
            currentVolume++;
        }else {
            currentVolume = 100;
        }

    }

    public void decreaseVolume() {
        setCurrentVolume(currentVolume);
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
