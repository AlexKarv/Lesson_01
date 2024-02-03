package lesson11_lamda;

import org.apache.commons.lang3.StringUtils;

public class FunctionalInterfaceWithLambda {

    @FunctionalInterface
    interface CheckNumber {
        boolean test(String s);
    }

    public static void print(String s, CheckNumber checkNumber) {
        if (checkNumber.test(s)) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        CheckNumber checkIsNumber = t -> StringUtils.isNumeric(t);
        CheckNumber checkIsAlpha = s -> StringUtils.isAlpha(s);

        System.out.println();
        print("123", checkIsNumber);
        print("abc", checkIsNumber);
        print("456", s -> StringUtils.isNumeric(s));

        System.out.println();
        print("123", checkIsAlpha);
        print("abc", checkIsAlpha);

        System.out.println();
        print("123", checkIsNumber);
        print("abc", checkIsAlpha);

//        // Example 9//        System.out.println();//        print("789", (String s) -> {//            System.out.println(123);//            System.out.println(456);//            System.out.println(789);//            return StringUtils.isAlpha(s);//        });//        System.out.println();//        MyClass myClass = new MyClass();//        myClass.test("789");    }

        class MyClass implements CheckNumber {

            @Override
            public boolean test(String s) {
                System.out.println(123);
                System.out.println(456);
                System.out.println(789);
                int a = 5;
                int b = 6;
                int c = 5 + 6;
                return StringUtils.isAlpha(s);
            }
        }
    }
}
