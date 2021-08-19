package ru.netology.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Radio {

    private final int amountStations;
    private int firstStation = 0;
    private int lastStation;
    private int currentStation;

    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;

    public int getLastStation() {
       lastStation = amountStations - 1;
        return lastStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > getLastStation()) {
            return;
        }
        if (currentStation < firstStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    // переключить на следующую станцию
    public int nextStation() {
        if (currentStation < getLastStation()) {
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
            currentStation = getLastStation();
        }

        return currentStation;

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
