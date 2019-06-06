import domain.Wishlist;
import javafx.application.Application;
import javafx.stage.Stage;
import mediator.Model;
import mediator.ModelManager;
import view.MainView;
import view.adminView.ViewAdminOnlyPage;
import viewmodel.ViewModel;

public class MainAdmin extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        Model model = new ModelManager() ;
        ViewModel viewModel = new ViewModel(model);
        MainView view = new MainView(primaryStage,viewModel);
        view.start("Test");
    }





    public static void main(String[] args) {
        launch(args);
    }
}
