package mediator;

import domain.Categories;
import domain.Product;

import java.util.ArrayList;

public interface Model {

    ArrayList<Product> getProducts(int amount);
    Product getProduct(Product product);
    Categories getCategory(Categories category);
    void addToWishlist(Product product);
    void addToShoppingbag(Product product);
    void removeFromWishlist(Product product);
    void removeFromShoppingBag(Product product);
    void purchase();
    


}
