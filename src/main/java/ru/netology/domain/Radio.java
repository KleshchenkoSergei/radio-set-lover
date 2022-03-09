package ru.netology.domain;

public class Radio {

    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > 9) {
            return;
        }
        if (currentStation < 0) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void next() {
        setCurrentStation(currentStation);
        currentStation++;
        if (currentStation > 9) {
            currentStation = 0;
        }
    }

    public void prev() {
        setCurrentStation(currentStation);
        currentStation--;
        if (currentStation < 0) {
            currentStation = 9;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > 10) {
            return;
        }
        if (currentVolume < 0) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        setCurrentVolume(currentVolume);
        if (currentVolume < 10) {
            currentVolume++;
        }

    }

    public void decreaseVolume() {
        setCurrentVolume(currentVolume);
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
