package ru.netology.radio;

public class Radio {

    public Radio() {

    }

    public Radio(int amountStations) {
        this.lastStation = amountStations - 1; // т.к. нумерация с нуля
    }

    private int firstStation = 0;
    private int lastStation = 9;
    private int currentStation;

    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;

    public int getFirstStation() {
        return firstStation;
    }

     public int getLastStation() {
        return lastStation;
    }

     public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > lastStation) {
            return;
        }
        if (currentStation < firstStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    // переключить на следующую станцию
    public int nextStation() {
        if (currentStation < lastStation) {
            currentStation += 1;
        } else {
            currentStation = firstStation;
        }
        return currentStation;
    }

    // переключить на предыдущую станцию
    public int prevStation() {
        if (currentStation > firstStation) {
            currentStation -= 1;
        } else {
            currentStation = lastStation;
        }

        return currentStation;

    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            return;
        }
        if (currentVolume < minVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    // увеличить громкость
    public int increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume += 1;
        }
        return currentVolume;
    }

    // уменьшить громкость
    public int decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume -= 1;
        }
        return currentVolume;
    }

}
