import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    public static Product binarySearch(Product[] products, String productName) {
        // Sort products by productName
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        return binarySearchHelper(products, productName, 0, products.length - 1);
    }

    public static Product binarySearchHelper(Product[] products,String productName,int left ,int right){
        if (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(productName);

            if (comparison == 0) {
                System.out.println("Found Product Successfully!");
                System.out.println();
                return products[mid];
                 
            } else if (comparison < 0) {
                return binarySearchHelper(products, productName, mid + 1, right);
            } else {
                return binarySearchHelper(products, productName, left, mid - 1);
            }
        }
        
        return null;
       
    }
}
