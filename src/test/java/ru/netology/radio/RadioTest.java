package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    public int defaultStations = 10; // выставляем макс кол-во станций по умолчанию для тестов

    @Test // выбор станции
    void setCurrentStation() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentStation(2);
        int expected = 2;
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test // выбор станции если другое количество
    void setCurrentStationIf20Station() {
        Radio radio = new Radio(20);

        radio.setCurrentStation(18);
        int expected = 18;
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test // станция не меньше 0

    void shouldNotSetCurrentStationLow0() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentStation(-2);
        int expected = 0;
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test // станция не больше 9
    void shouldNotSetCurrentStationHigher9() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentStation(22);
        int expected = 0;
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test // прибавляем станцию
    void shouldSetNextStation() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentStation(8);
        int actual = radio.nextStation();
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test // после последней идет первая (9->0)
    void shouldSetFirstStationIfSetLast() {
        Radio radio = new Radio(25);

        radio.setCurrentStation(radio.getLastStation()); //устанавливаем последнюю станцию
        int actual = radio.nextStation();
        int expected = radio.getFirstStation();

        assertEquals(expected, actual);
    }

    @Test // убавляем станцию
    void shouldSetPrevStation() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentStation(2);
        int actual = radio.prevStation();
        int expected = 1;

        assertEquals(expected, actual);
    }


    @Test // после первой идет последняя (0->9)
    void shouldSetLastStationIfSetFirst() {
        Radio radio = new Radio(20);

        radio.setCurrentStation(radio.getFirstStation());
        int actual = radio.prevStation();
        int expected = radio.getLastStation();

        assertEquals(expected, actual);
    }

    @Test // проверяем максимум громкости
    void shouldNotSetHigherMaxVolume() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentVolume(120);
        int actual = radio.getCurrentVolume();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test // проверяем минимум громкости
    void shouldNotSetLowerMinVolume() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentVolume(-5);
        int actual = radio.getCurrentVolume();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test // увеличиваем громкость
    void shouldIncreaseVolume() {
        Radio radio = new Radio(defaultStations);

        int actual = radio.increaseVolume();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test // не увеличить после максимума
    void shouldNotIncreaseVolumeIfMax() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentVolume(radio.getMaxVolume());
        int actual = radio.increaseVolume();
        int expected = radio.getMaxVolume();

        assertEquals(expected, actual);
    }

    @Test // уменьшаем громкость
    void shouldDecreaseVolume() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentVolume(5);
        int actual = radio.decreaseVolume();
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test // не убавить если минимум
    void shouldNotDecreaseVolumeIfMin() {
        Radio radio = new Radio(defaultStations);

        radio.setCurrentVolume(radio.getMinVolume());
        int actual = radio.decreaseVolume();
        int expected = radio.getMinVolume();

        assertEquals(expected, actual);
    }

}