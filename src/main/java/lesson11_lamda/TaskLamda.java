package lesson11_lamda;

public class TaskLamda {

    /*
    Завдання 1. Написати функціональний інтерфейс із методом, який приймає число та повертає булеве значення.
    Написати реалізацію такого інтерфейсу як лямбда-выражения, яке повертає true
    якщо передане число ділиться без залишку на 13.

Завдання 2. Написати функціональний інтерфейс із методом,
який приймає два рядки та повертає теж рядок. Написати реалізацію такого інтерфейсу у вигляді лямбди,
 яка повертає той рядок, який довший.

Завдання 3. Написати функціональний інтерфейс із методом,
який приймає три дробові числа (double): a, b, c і повертає теж дробове число.
Написати реалізацію такого інтерфейсу як лямбда-выражения, яке повертає дискримінант. Хто забув, D = b^2 - 4ac.

Завдання 4. Використовуючи функціональний інтерфейс із завдання 3 написати лямбда-вираз,
який повертає результат операції a*b^c.
     */

    @FunctionalInterface
    interface CheckNumber {
        boolean test(int s);
    }

    @FunctionalInterface
    interface CheckString {
        String findLongString(String s1, String s2);
    }
    @FunctionalInterface
    interface CheckDouble {
        double findDiscriminant(double a, double b, double d);
    }

    public static void main(String[] args) {



        CheckDouble checkDouble = (a, b, c) -> {
           return  (b*b) - 4*a*c;
                    };

        CheckDouble checkDouble1 = (a, b, d) -> a * Math.pow(b, d);

        System.out.println(checkDouble1.findDiscriminant(2.,3.,4.));
        System.out.println(checkDouble.findDiscriminant(2.,3.,4.));
//        CheckString checkString = (s1, s2) ->
//        {
//            if (s1.length() > s2.length())
//                return s1;
//            else {
//                return s2;
//            }
//        };

       // System.out.println(checkString.findLongString("asdfgh","qi"));
        //CheckNumber checkNumber = s -> s % 13 == 0;
//        checkNumber.test(130);

        // System.out.println(checkNumber.test(10));


    }

}
