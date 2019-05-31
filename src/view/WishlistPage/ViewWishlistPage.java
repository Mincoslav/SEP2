package view.WishlistPage;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import view.MainView;
import viewmodel.ViewModel;

import java.io.IOException;

public class ViewWishlistPage {
    public Button returnButt;
    public ListView listView;
    public Button remove;
    public Button bag;
    public MainView mainView;
    public ViewModel viewModel;

    public void init(MainView mainView, ViewModel viewModel){
        this.mainView = mainView;
        this.viewModel = viewModel;
        listView.itemsProperty().bind(viewModel.simpleListPropertyStringWish());
    }

    public void backHome(ActionEvent actionEvent) {
        try {
            mainView.openView("Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeItem(ActionEvent actionEvent) {
        int index = listView.getSelectionModel().getSelectedIndex();
        listView.getItems().remove(index);
        viewModel.removeFromWishlist(viewModel.getWishlist().getProduct(index));
    }

    public void addToBag(ActionEvent actionEvent) {
        int index = listView.getSelectionModel().getSelectedIndex();
        viewModel.addToShoppinBag(viewModel.getWishlist().getProduct(index));
    }
}
