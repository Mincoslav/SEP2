package viewmodel;

import domain.Categories;
import domain.Product;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import view.ViewHomePage;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Locale;

public class ViewModel implements PropertyChangeListener {

	private Model model;
	private SimpleObjectProperty<Product> product;

	public ViewModel(Model model){
	    this.model = model;
        model.addListener("AddWish",this::updateWishList);
        model.addListener("RemoveWish",this::updateWishList);
        model.addListener("AddBag",this::updateWishList);
        model.addListener("RemoveBag",this::updateWishList);
        product = new SimpleObjectProperty<>();
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void updateWishList(PropertyChangeEvent evt) {
        Product wished = (Product) evt.getOldValue();
        product.set(wished);
    }

    public Categories getCategories(Categories categories){
	   return model.getCategory(categories);
    }

    public void addToWishList(Product product){
        model.addToWishlist(product);
    }

    public void removeFromWishlist(Product product){
	    model.removeFromWishlist(product);
    }

    public void addToShoppinBag(Product product){
	    model.addToShoppingbag(product);
    }

    public void removeFromShoppingBag(Product product){
	    model.removeFromShoppingBag(product);
    }

    public SimpleObjectProperty<Product> objectProperty() {
	    return product;
    }



}
