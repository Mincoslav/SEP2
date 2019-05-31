package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.PurchasePage.ViewPurchasePage;
import view.ShoppingBagPage.ViewShoppingBagPage;

import view.WishlistPage.ViewWishlistPage;
import viewmodel.ViewModel;

import java.io.IOException;

public class MainView {
    private Stage stage;
    private ViewModel viewModel;

    public MainView(Stage stage, ViewModel viewModel){
        this.stage = stage;
        this.viewModel = viewModel;
    }

    public void start() throws Exception{
        openView("Home");
    }

    public void openView(String viewToOpen) throws IOException{
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        if(("Home").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("homeasdas.fxml"));
            System.out.println(String.valueOf(loader.equals(null)));
            root = loader.load();

            ViewHomePage view = loader.getController();
            view.initialize(this,viewModel);

            stage.setTitle("Home Page");
        }

        if(("Item").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("itemPage.fxml"));
            root = loader.load();
            ViewItemPage view = loader.getController();
            view.init(viewModel);
            stage.setTitle("Item Page");
        }

        if(("Purchase").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("PurchasePage/purchasePage.fxml"));
            root = loader.load();
            ViewPurchasePage view = loader.getController();
            view.init(viewModel,this);
            stage.setTitle("Checkout");
        }

        if(("WishList").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("WishlistPage/wishlistPage.fxml"));
            root = loader.load();
            ViewWishlistPage view = loader.getController();
            view.init(this,viewModel);
            stage.setTitle("WishList");
        }

        if(("ShoppingBag").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("ShoppingBagPage/shoppingBagPage.fxml"));
            root = loader.load();
            ViewShoppingBagPage view = loader.getController();
            view.init(viewModel,this);
            stage.setTitle("Shopping Bag");
        }




        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
