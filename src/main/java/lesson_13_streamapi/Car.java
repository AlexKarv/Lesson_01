package lesson_13_streamapi;

import java.math.BigDecimal;

public class Car {
    /*
    Створити клас "Автомобіль". У класі має зберігатися така інформація:

    назва автомобіля;

    рік випуску;

    вартість;

    колір;

    об'єм двигуна.

    Потрібно створити список автомобілів (використати List.of) та виконати такі завдання:

    відобразити всі автомобілі;

    відобразити автомобілі вказаного кольору

    відобразити автомобілі дорожче зазначеної ціни;

    відобразити автомобілі, чий рік випуску знаходиться у заданому діапазоні;

    сортувати автомобілі в порядку зменшення вартості.
    */
    String name;
    Integer year;
    BigDecimal price;
    String color;
    Double volume;

    public Car(String name, Integer year, BigDecimal price, String color, Double volume) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", volume=" + volume +
                '}';
    }
}
