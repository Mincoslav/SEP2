package viewmodel;

import domain.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewModel implements PropertyChangeListener {


    private  SimpleStringProperty priceItem;
    private  SimpleStringProperty nameItem;


    private  SimpleStringProperty descriptionItem;
    private Model model;
	private Product product;
	private StringProperty label_1;
    private StringProperty label_2;
    private StringProperty label_3;
    private StringProperty label_4;
    private StringProperty label_5;
    private StringProperty label_6;
    private StringProperty price;
    private SimpleListProperty<Product> list;
    private SimpleListProperty<Product> listWish; //list For WishList
    private SimpleListProperty<String> listWishString;
    private SimpleListProperty<String> listString; //list  of Products from Shopping bag
    private SimpleStringProperty orderID;


    public ViewModel(Model model){
	    this.model = model;
        model.addListener("AddWish",this::updateWishList);
        //model.addListener("RemoveWish",this::updateWishList);
        model.addListener("AddBag",this::updateBag);
        //model.addListener("RemoveBag",this::updateBag);
        model.addListener("IncreaseDecrease",this::quantityUpdate);
        model.addListener("Product",this::propertyChange);
        model.addListener("Purchase",this::purchaseChange);

        orderID = new SimpleStringProperty();
        label_1 = new SimpleStringProperty();
        label_2 = new SimpleStringProperty();
        label_3 = new SimpleStringProperty();
        label_4 = new SimpleStringProperty();
        label_5 = new SimpleStringProperty();
        label_6 = new SimpleStringProperty();
        price = new SimpleStringProperty();
        priceItem = new SimpleStringProperty();
        nameItem = new SimpleStringProperty();
        descriptionItem = new SimpleStringProperty();

        list = new SimpleListProperty<>(FXCollections.observableArrayList());
        listWish = new SimpleListProperty<>(FXCollections.observableArrayList());
        listWishString = new SimpleListProperty<>(FXCollections.observableArrayList());
        listString = new SimpleListProperty<>(FXCollections.observableArrayList());

    }

    private void purchaseChange(PropertyChangeEvent propertyChangeEvent) {
        int id = (int) propertyChangeEvent.getNewValue();
        orderID.setValue( "Your ORDER ID: #" + id);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Product wished = (Product) evt.getOldValue();
        String name = (String) evt.getNewValue();
        nameItem.setValue("Product: " + name);
        priceItem.setValue("Price: " + wished.getPrice()+"");
        descriptionItem.setValue("Description: " + wished.getDescription());
    }

    public void updateWishList(PropertyChangeEvent evt) {
        Product wished = (Product) evt.getOldValue();
        String name = (String) evt.getNewValue();
        listWish.add(wished);
        listWishString.add(name);


    }
    public void updateBag(PropertyChangeEvent evt) {
        Product wished = (Product) evt.getOldValue();
        String name = (String) evt.getNewValue();
        list.add(wished);
        listString.add(name + " Qnt:" + wished.getPurchasedQuantity()+ " Price: " + wished.getPrice());
        price.setValue(model.getShoppingBag().subTotal()+"");

    }

    //updates quantity in the shopping bag
    public void quantityUpdate(PropertyChangeEvent evt) {
        Product wished = (Product) evt.getOldValue();
        int index = (int) evt.getNewValue();
        System.out.println(list.get(0).getName());
        list.set(index,wished);
        listString.set(index,wished.getName() + " Qnt:" + wished.getPurchasedQuantity()+ " Price: " + wished.getPrice());
        price.setValue(model.getShoppingBag().subTotal()+"");
    }

    public void purchase(String name,String adress,int phone) throws RemoteException, SQLException {
	    model.purchase(name,adress,phone);
    }

    public List<Product> getCategories(Categories categories) throws ClassNotFoundException, SQLException, RemoteException {
	   return model.getCategory(categories).getCategoryProducts();
    }

    public Wishlist getWishlist() {
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

    public void increasePurchasedQuantity(int index) {
        model.increaseDecrease("increase",index);
    }

    public void decreasePurchasedQuantity(int index) {
        model.increaseDecrease("decrease",index);

    }

    public Product objectProperty() {
	    return product;
    }

    public List<Product> getProductsPerPagePerCategory(Categories categories,int page) throws ClassNotFoundException, SQLException, RemoteException {
	    page = page * 6 - 6;
        ArrayList<Product> listOfProducts = null;
        ArrayList<Product> displayedProducts = new ArrayList<>();


        listOfProducts = (ArrayList<Product>) model.getCategory(categories).getCategoryProducts();

        for (int i = 0; i + page < 6 + page && i < listOfProducts.size(); i++) {
            displayedProducts.add(listOfProducts.get(i));
        }

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
        return displayedProducts;
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

    public ListProperty<String> simpleListPropertyStringWish(){
        //  for(int i = 0; i  < model.getShoppingBag().getAllProducts().size();i++){
        //      listString.add(model.getBag().get(i).getName());
        //  }
        return listWishString;
    }


    public StringProperty priceProperty() {
        return price;
    }

    public void getAProduct(Product product){
	    this.product = product;
	    model.getAProduct(product);
    }


    public SimpleStringProperty priceItemProperty() {
        return priceItem;
    }



    public SimpleStringProperty nameItemProperty() {
        return nameItem;
    }



    public SimpleStringProperty descriptionItemProperty() {
        return descriptionItem;
    }

    public SimpleStringProperty orderIDProperty() {
        return orderID;
    }

    public Order finOrderByID(int id) throws RemoteException, SQLException {

            return model.getOrderByID(id);

    }
}
