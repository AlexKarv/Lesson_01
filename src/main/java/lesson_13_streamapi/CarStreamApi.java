package lesson_13_streamapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarStreamApi {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Opel", 2015, new BigDecimal("15000.01"), "yellow", 1.5));
        cars.add(new Car("MMM", 2017, new BigDecimal("15200.01"), "red", 3.5));
        cars.add(new Car("Niva", 2014, new BigDecimal("19000.01"), "blue", 2.5));
        cars.add(new Car("Reno", 2016, new BigDecimal("18000.01"), "yellow", 1.5));
        cars.add(new Car("audi", 2015, new BigDecimal("17000.01"), "yellow", 1.9));
        cars.add(new Car("nissan", 2015, new BigDecimal("15000.01"), "yellow", 1.5));
        cars.add(new Car("mazda", 2025, new BigDecimal("15000.01"), "yellow", 1.6));

        printCars(cars);
        System.out.println("---------------------------------");
        List<Car> colorCars = cars.stream().filter(car -> car.getColor().equals("yellow")).collect(Collectors.toList());
        printCars(colorCars);
        System.out.println("---------------------------------");
        List<Car> priceCars = cars.stream().filter(car -> car.getPrice().compareTo(new BigDecimal("16000.0")) > 0).collect(Collectors.toList());
        printCars(priceCars);
        List<Car> sortCars = cars.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).collect(Collectors.toList());
        System.out.println("---------------------------------");
        printCars(sortCars);
        List<Car> sortYearsCars = cars.stream().filter(car -> car.getYear() >= 2016 && car.getYear() <= 2023).collect(Collectors.toList());
        System.out.println("---------------------------------");
        printCars(sortYearsCars);

    }


    public static void printCars(List<Car> cars) {
        cars.forEach(System.out::println);
    }


}
