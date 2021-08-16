package ru.netology.radio;

public class Radio {

    private int firstStation = 0;
    private int lastStation = 9;
    private int currentStation;

    private int minVolume = 0;
    private int maxVolume = 10;
    private int currentVolume;

    public int getFirstStation() {
        return firstStation;
    }

    public int getLastStation() {
        return lastStation;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }


    // возможность выставлять номер радиостанции с цифрового пульта (вводя числа 0 - 9)
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
        } else if (currentStation == lastStation) {
            currentStation = 0;
        }
        return currentStation;
    }

    // переключить на предыдущую станцию
    public int prevStation() {
        if (currentStation > firstStation) {
            currentStation -= 1;
        } else if (currentStation == firstStation) {
            currentStation = 9;
        }
        return currentStation;

    }

    // настраиваем, что громкость может быть от мин до макс
    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            return;
        }
        if (currentVolume < minVolume) {
            return;
        }
        this.currentVolume = currentVolume;
//        return currentVolume;
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
