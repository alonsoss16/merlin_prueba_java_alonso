package es.merlinsoftware;

import es.merlinsoftware.pojo.ProductSales;
import es.merlinsoftware.pojo.ProductStock;

import java.util.*;

public class Solution {

    public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {
        //TODO: Complete this method with the solution, you don't need to split your solution over multiple classes,
        // just get it done!

        Map<Long, Double> productScores = new HashMap<>();

        Map<Long, ProductSales> salesMap = new HashMap<>();
        for (ProductSales sales : productsSalesInformation) {
            salesMap.put(sales.getProductId(), sales);
        }

        Map<Long, ProductStock> stockMap = new HashMap<>();
        for (ProductStock stock : productsStockInformation) {
            stockMap.put(stock.getProductId(), stock);
        }

        for (Long productId : stockMap.keySet()) {
            ProductSales sales = salesMap.get(productId);
            ProductStock stock = stockMap.get(productId);

            if (sales != null && stock != null) {
                double salesScore = sales.getSalesAmount() * salesWeight;
                double stockScore = (double) stock.getAvailableStock() * stockWeight;
                double totalScore = salesScore + stockScore;

                productScores.put(productId, totalScore);
            }
        }


        List<Long> sortedProductIds = new ArrayList<>(productScores.keySet());
        sortedProductIds.sort((p1, p2) -> Double.compare(productScores.get(p2), productScores.get(p1)));

        return sortedProductIds;
    }

}
