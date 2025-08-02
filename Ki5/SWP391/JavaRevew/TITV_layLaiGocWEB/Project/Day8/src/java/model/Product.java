package model;

public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private int stockQuantity;
    private String imageUrl;
    private String category;
    private int stock; // 1 = đang bán, 0 = ngừng bán

    public Product(int id, String name, String description, int price,
                   int stockQuantity, String imageUrl, String category, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
        this.category = category;
        this.stock = stock;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id + ", name='" + name + '\'' +
                ", price=" + price + ", stockQuantity=" + stockQuantity +
                ", category='" + category + '\'' +
                ", stock=" + stock + '}';
    }
}
