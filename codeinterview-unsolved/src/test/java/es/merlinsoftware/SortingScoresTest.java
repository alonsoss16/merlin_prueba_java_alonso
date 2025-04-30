package es.merlinsoftware;

import static org.junit.Assert.assertTrue;

import es.merlinsoftware.pojo.ProductSales;
import es.merlinsoftware.pojo.ProductStock;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingScoresTest {
    @Test
    public void testHappyPath() {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(2L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, 75000.0));


        List<ProductStock> productStock = new ArrayList<>();
        productStock.add(new ProductStock(1L, 100000L));
        productStock.add(new ProductStock(2L, 400000L));
        productStock.add(new ProductStock(3L, 200000L));
        productStock.add(new ProductStock(4L, 300000L));

        //Caso 50/50
        Long[] expectedResult1 = {2L, 4L, 3L, 1L};

        Assert.assertArrayEquals(Solution.sortProductsByScores(50, 50, productStock, productSales).toArray(),
                expectedResult1);

        //Pruebas extra:
        //Caso 75/25
        Long[] expectedResult2 = {2L, 4L, 3L, 1L};

        Assert.assertArrayEquals(Solution.sortProductsByScores(75, 25, productStock, productSales).toArray(),
                expectedResult2);

        //Caso 25/75
        Long[] expectedResult3 = {2L, 4L, 3L, 1L};

        Assert.assertArrayEquals(Solution.sortProductsByScores(25, 75, productStock, productSales).toArray(),
                expectedResult3);

        //Caso 100/0
        Long[] expectedResult4 = {2L, 4L, 3L, 1L};

        Assert.assertArrayEquals(Solution.sortProductsByScores(100, 0, productStock, productSales).toArray(),
                expectedResult4);

        //Caso 0/100
        Long[] expectedResult5 = {3L, 4L, 2L, 1L};

        Assert.assertArrayEquals(Solution.sortProductsByScores(0, 100, productStock, productSales).toArray(),
                expectedResult5);
    }
}
