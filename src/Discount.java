import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discount {
    public static void main(String[] args) {

        Product product1 = new Product("Pen", 1, 100);
        Product product2 = new Product("Pencil", 1, 250);

        ShoppingCard shoppingCard = new ShoppingCard();

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product2);
        products.add(product2);
        products.add(product2);

        shoppingCard.setProductList(products);


        System.out.println("first discount:" + discount(shoppingCard));
        System.out.println("second discount:" + secondDiscount(shoppingCard));
        change(shoppingCard, product2);
    }

    public static int discount(ShoppingCard sc) {
        int total = 0;
        for (Product i : sc.getProductList()) {

            total = total + i.getPrice();
        }
        if (sc.getProductList().size() >= 5) {
            int discount = 0;
            discount = total / 10;
            total = total - discount;
            return total;

        } else {
            return total;
        }
    }

    public static double secondDiscount(ShoppingCard sc) {
        Map<String, Product> count = new HashMap<>();
        for (Product i : sc.getProductList()) {
            if (!count.containsKey(i.getName())) {
                count.put(i.getName(), i);
            } else {
                Product n = count.get(i.getName());
                int newCount = n.getCount() + 1;
                n.setCount(newCount);
                count.put(i.getName(), n);
            }
        }
        double totalprice = 0;
        Object[] arr = count.values().toArray();
        for (int i = 0; i < arr.length; i++) {
            int p = ((Product) arr[i]).getCount();
            totalprice = totalprice + (p - Math.floor(p / 4)) * ((Product) arr[i]).getPrice();
        }
        return (totalprice);
    }

    public static void change(ShoppingCard sc, Product product) {
        for (Product i : sc.getProductList()) {
            if (i.getName() != product.getName()) {
                i = product;
            }
            System.out.println(i.getName());
        }
    }
}
