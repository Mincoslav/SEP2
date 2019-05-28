package viewmodel;

import domain.Categories;
import domain.Product;
import domain.ShoppingBag;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ViewModel implements PropertyChangeListener {

	private Model model;
	private SimpleObjectProperty<Product> product;
	private StringProperty label_1;
    private StringProperty label_2;
    private StringProperty label_3;
    private StringProperty label_4;
    private StringProperty label_5;
    private StringProperty label_6;
    private SimpleListProperty<Product> list;
    private SimpleListProperty<String> listString;



	public ViewModel(Model model){
	    this.model = model;
        model.addListener("AddWish",this::updateWishList);
        model.addListener("RemoveWish",this::updateWishList);
        model.addListener("AddBag",this::updateBag);
        model.addListener("RemoveBag",this::updateBag);
        product = new SimpleObjectProperty<>();
        label_1 = new SimpleStringProperty();
        label_2 = new SimpleStringProperty();
        label_3 = new SimpleStringProperty();
        label_4 = new SimpleStringProperty();
        label_5 = new SimpleStringProperty();
        label_6 = new SimpleStringProperty();
        list = new SimpleListProperty<>(FXCollections.observableArrayList());
        listString = new SimpleListProperty<>(FXCollections.observableArrayList());

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void updateWishList(PropertyChangeEvent evt) {
        Product wished = (Product) evt.getOldValue();
        product.set(wished);

    }
    public void updateBag(PropertyChangeEvent evt) {
        Product wished = (Product) evt.getOldValue();
        String name = (String) evt.getNewValue();
        list.add(wished);
        listString.add(name + " Qnt:" + wished.getPurchasedQuantity()+ " Price: " + wished.getPrice());
    }


    public List<Product> getCategories(Categories categories){
	   return model.getCategory(categories).getCategoryProducts();
    }

    public ArrayList<Product> getWishlist() {
	    return model.getWishlist();
    }

    public ShoppingBag getBag() {
        return model.getShoppingBag()   ;
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

    public void getProductsPerPagePerCategory(Categories categories,int page) {
	    page = page * 6 - 6;
        ArrayList<Product> listOfProducts = null;
        ArrayList<Product> displayedProducts = new ArrayList<>();


        listOfProducts = (ArrayList<Product>) model.getCategory(categories).getCategoryProducts();

        for (int i = 0; i + page < 6 + page && i < listOfProducts.size(); i++) {
            displayedProducts.add(listOfProducts.get(i));
        }

        System.out.println(displayedProducts.size());
        displayedProducts.add(0,new Product("hey",null,0,0,0,0,false,"",0));
                             System.out.println(displayedProducts.size());

        for (int i = 0; i < displayedProducts.size(); i++) {
            if (!(displayedProducts.get(i).equals(null))) {
                switch (i) {
                    case 0:
                        label_1.setValue(displayedProducts.remove(i).getName());
                        break;
                    case 1:
                        label_2.setValue(displayedProducts.remove(i).getName());
                        break;
                    case 2:
                        label_3.setValue(displayedProducts.remove(i).getName());
                        break;
                    case 3:
                        label_4.setValue(displayedProducts.remove(i).getName());
                        break;
                    case 4:
                        label_5.setValue(displayedProducts.remove(i).getName());
                        break;
                    case 5:
                        label_6.setValue(displayedProducts.remove(i).getName());
                        break;
                }
            }
        }
    }

    public StringProperty label_1Property() {
        return label_1;
	}

    public StringProperty label_2Property() {
        return label_2;
    }

    public StringProperty label_3Property() {
        return label_3;
    }

    public StringProperty label_4Property() {
        return label_4;
    }

    public StringProperty label_5Property() {
        return label_5;
    }

    public StringProperty label_6Property() {
        return label_6;
    }

    public SimpleListProperty<Product> simpleListProperty(){
        for(int i = 0; i  < model.getShoppingBag().getAllProducts().size();i++){
           list.add(model.getBag().get(i));
        }
	    return list;
    }

    public ListProperty<String> simpleListPropertyString(){
     //  for(int i = 0; i  < model.getShoppingBag().getAllProducts().size();i++){
     //      listString.add(model.getBag().get(i).getName());
     //  }
        return listString;
    }



}
