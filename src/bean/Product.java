package bean;

public class Product {
    private int id;
    private int catalogId;
    private String name;
    private int price;

    // ゲッター・セッター
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCatalogId() { return catalogId; }
    public void setCatalogId(int catalogId) { this.catalogId = catalogId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
