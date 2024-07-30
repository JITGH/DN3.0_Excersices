public class LinearSearch {
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println("Found Product Successfully!");
                System.out.println();
                return product;
               
            }
        }
         
        return null;
       
    }
}
