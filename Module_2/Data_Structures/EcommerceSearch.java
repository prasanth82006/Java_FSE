package Module_2.Data_Structures;
import java.util.Arrays;

class SearchableProduct implements Comparable<SearchableProduct> {
    private String productId;
    private String productName;
    private String category;

    public SearchableProduct(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public int compareTo(SearchableProduct o) {
        return this.productId.compareTo(o.productId);
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " (" + category + ")";
    }
}

public class EcommerceSearch {

    public static SearchableProduct linearSearch(SearchableProduct[] products, String targetId) {
        for (SearchableProduct p : products) {
            if (p.getProductId().equals(targetId)) {
                return p;
            }
        }
        return null;
    }

    public static SearchableProduct binarySearch(SearchableProduct[] products, String targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = products[mid].getProductId().compareTo(targetId);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SearchableProduct[] products = {
            new SearchableProduct("101", "Wireless Mouse", "Electronics"),
            new SearchableProduct("105", "Mechanical Keyboard", "Electronics"),
            new SearchableProduct("110", "Gaming Monitor", "Electronics"),
            new SearchableProduct("120", "Desk Mat", "Accessories")
        };

        Arrays.sort(products);

        System.out.println("Searching via Linear Search (ID: 110):");
        System.out.println("Found: " + linearSearch(products, "110"));

        System.out.println();

        System.out.println("Searching via Binary Search (ID: 105):");
        System.out.println("Found: " + binarySearch(products, "105"));
    }
}