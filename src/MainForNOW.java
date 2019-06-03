import domain.*;
import javafx.application.Application;
import javafx.stage.Stage;
import mediator.Model;
import mediator.ModelManager;
import view.MainView;
import viewmodel.ViewModel;


public class MainForNOW  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Product algo = new Product("cool","url",23,1,25,2,true,"Amazing quality for th price",0);
        Products novo = new Products();
        novo.addProduct(algo);
        Categories category = new Categories(1,"Jackets");
        category.addProduct(algo);
        Wishlist ness = new Wishlist();
        Model model = new ModelManager() ;
        ViewModel viewModel = new ViewModel(model);
        MainView view = new MainView(primaryStage,viewModel);


        /*model.getCategory(category).addProduct(algo);

        System.out.println(model.getBag().size());*/

        view.start();
        /*model.addProduct(algo);
        model.addToShoppingbag(algo);
        model.addToWishlist(algo);*/
    }



    public static void main(String[] args) {
        launch(args);
    }
}
