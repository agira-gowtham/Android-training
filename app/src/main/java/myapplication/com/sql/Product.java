package myapplication.com.sql;

/**
 * Created by root on 19/9/17.
 */

public class Product {
    int productid;
    String productname;
    String price;
    String instock;
    String offer;
    String color;
    String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public int getProductid() {
        return productid;
    }

    public String getColor() {
        return color;
    }

    public String getInstock() {
        return instock;
    }

    public String getOffer() {
        return offer;
    }

    public String getPrice() {
        return price;
    }

    public String getProductname() {
        return productname;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setInstock(String instock) {
        this.instock = instock;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}

