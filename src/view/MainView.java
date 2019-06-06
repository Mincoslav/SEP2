package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.PreviousOrdersPAge.ViewPreviousOrders;
import view.PurchasePage.ViewMessagePage;
import view.PurchasePage.ViewPurchasePage;
import view.ShoppingBagPage.ViewShoppingBagPage;

import view.Tabs.JacketsTabController;
import view.Tabs.ViewHomePage;
import view.ViewItemPage;
import view.WishlistPage.ViewWishlistPage;
import view.adminView.ViewAdminOnlyPage;
import viewmodel.ViewModel;

import java.io.IOException;

public class MainView {
    private Stage stage;
    private ViewModel viewModel;

    public MainView(Stage stage, ViewModel viewModel){
        this.stage = stage;
        this.viewModel = viewModel;
    }

    public void start(String viewToOpen) throws Exception{
        openView(viewToOpen);
    }

    public void openView(String viewToOpen) throws IOException{
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        if(("Home").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("alternateHomePage.fxml"));
            System.out.println(loader.getLocation());
            root = loader.load();

            ViewAlternativeHomePage view = loader.getController();
            view.initialize(this,viewModel);

            stage.setTitle("Home Page");
        }



        if(("Test").equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("adminView/adminOnlyPage.fxml"));
            root = loader.load();

            ViewAdminOnlyPage view = loader.getController();
            view.initialize(viewModel);

            stage.setTitle("Admin Page");
        }

        if(("Item").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("itemPage.fxml"));
            root = loader.load();
            ViewItemPage view = loader.getController();
            view.init(viewModel,this);
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

        if(("End").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("PurchasePage/messagePage.fxml"));
            root = loader.load();
            ViewMessagePage view = loader.getController();
            view.init(viewModel,this);
            stage.setTitle("Finished");
        }
        if(("Orders").equals(viewToOpen)){
            loader.setLocation(getClass().getResource("PreviousOrdersPAge/PreviousOrders.fxml"));
            root = loader.load();
            ViewPreviousOrders view = loader.getController();
            view.init(viewModel,this);
            stage.setTitle("Previous Orders");
        }





        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
