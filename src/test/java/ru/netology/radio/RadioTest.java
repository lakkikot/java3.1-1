package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test // выбор станции
    void setCurrentStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(2);
        int expected = 2;
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test // станция не меньше 0

    void shouldNotSetCurrentStationLow0() {
        Radio radio = new Radio();

        radio.setCurrentStation(-2);
        int expected = 0;
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test // станция не больше 9
    void shouldNotSetCurrentStationHigher9() {
        Radio radio = new Radio();

        radio.setCurrentStation(22);
        int expected = 0;
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test // прибавляем станцию
    void shouldSetNextStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);
        int actual = radio.nextStation();
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test // после последней идет первая (9->0)
    void shouldSet0StationIfSetLast() {
        Radio radio = new Radio();

        radio.setCurrentStation(radio.getLastStation()); //устанавливаем последнюю станцию
        int actual = radio.nextStation();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test // убавляем станцию
    void shouldSetPrevStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(1);
        int actual = radio.prevStation();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test // после первой идет последняя (0->9)
    void shouldSet9StationIfSetFirst() {
        Radio radio = new Radio();

        radio.setCurrentStation(radio.getFirstStation());
        int actual = radio.prevStation();
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test // проверяем максимум громкости
    void shouldNotSetHigherMaxVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(20);
        int actual = radio.getCurrentVolume();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test // проверяем минимум громкости
    void shouldNotSetLowerMinVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(-5);
        int actual = radio.getCurrentVolume();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test // увеличиваем громкость
    void shouldIncreaseVolume() {
        Radio radio = new Radio();

        int actual = radio.increaseVolume();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test // не увеличить после максимума
    void shouldNotIncreaseVolumeIfMax() {
        Radio radio = new Radio();

        radio.setCurrentVolume(radio.getMaxVolume());
        int actual = radio.increaseVolume();
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test // уменьшаем громкость
    void shouldDecreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(5);
        int actual = radio.decreaseVolume();
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test // не убавить если минимум
    void shouldNotDecreaseVolumeIfMin() {
        Radio radio = new Radio();

        radio.setCurrentVolume(radio.getMinVolume());
        int actual = radio.decreaseVolume();
        int expected = 0;

        assertEquals(expected, actual);
    }
}