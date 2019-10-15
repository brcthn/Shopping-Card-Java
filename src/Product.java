public class Product {

    private String  name;
    private Integer count;
    private Integer price;

    public Product(String name, Integer count, Integer price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public Integer getCount() {
        return count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
