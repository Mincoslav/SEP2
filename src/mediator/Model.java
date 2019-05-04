package mediator;

import domain.Categories;
import domain.Product;

public interface Model {

    Product getProducts(int amount);
    Categories getCategory(Categories category);
    void addToWishlist(Product product);
    void addToShoppingbag(Product product);
    void removeFromWishlist(Product product);
    void removeFromShoppingBag(Product product);
    void purchase();


}
