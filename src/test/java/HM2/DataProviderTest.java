package HM2;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test
    public void testDataWithoutDP() {
//        String n1 = "Lena";
//        int n2 = 51;

        String n1 = "Petro";
        int n2 = 41;

        System.out.println(n1 + " " + n2);
        Assert.assertEquals(n1 + " " + n2, "Petro 41");
    }


    @DataProvider
    public Object[][] createData() {
        return new Object[][]{
                {"Andrii", 36},
                {"Alex", 37},
        };
    }

    @Test(dataProvider = "createData")
//    @Test(dataProvider = "dataProvider3")
    public void testData(String n1, int n2) {
        System.out.println(n1 + " " + n2);
    }



    int[] arrayForTest = {1, -2, 3, -4, 5, -6};

    @Test
    public void TestArray1() {
        for (int arrayElement : arrayForTest ) {
            Assert.assertTrue(arrayElement > 0);
        }
    }

    @Test(dataProvider = "dataProvider2")
    public void TestArray2(int j) {
        Assert.assertTrue(j > 0);
    }

    @Test(dataProvider = "dataProvider3")
    public void TestArray3(int j, String str) {
        System.out.println(j + " " + str);
    }

    @DataProvider
    public Object[] dataProvider2 () {
        return new Object[]{1, -2, 3, -4, 5, -6};
    }

    @DataProvider
    public Object[][] dataProvider3 () {
        return new Object[][] {
                {1, "one"},
                {2, "two"},
                {3, "three"},
//                {"four", 4},
//                {5},
//                {6, "six", 7},
        };
    }
}
