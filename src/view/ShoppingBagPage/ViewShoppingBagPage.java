package view.ShoppingBagPage;
import domain.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import view.MainView;
import viewmodel.ViewModel;

import java.io.IOException;

public class ViewShoppingBagPage {
    private Button removeButt;
    private Button decreaseButt;
    private Button increaseButt;
    private ViewModel viewModel;
    private ListView listBag;
    private MainView mainView;

    @FXML
    public void init(ViewModel viewModel, MainView mainView) {

        this.viewModel = viewModel;

        listBag.itemsProperty().bindBidirectional(viewModel.simpleListProperty());

    }

    public void removeItem(ActionEvent actionEvent) {
        int index = listBag.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
           listBag.getItems().remove(index);
        }
    }

    public void checkoutButton(ActionEvent actionEvent) {
        try {
            mainView.openView("Purchase");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decrease(ActionEvent actionEvent) {
        int index = listBag.getSelectionModel().getSelectedIndex();
        Product prod = (Product) listBag.getItems().get(index);
        viewModel.getBag().changeQuantity(index,viewModel.getBag().getProduct(index).getPurchasedQuantity() - 1);
    }

    public void increase(ActionEvent actionEvent) {
        int index = listBag.getSelectionModel().getSelectedIndex();
        Product prod = (Product) listBag.getItems().get(index);
        viewModel.getBag().changeQuantity(index,viewModel.getBag().getProduct(index).getPurchasedQuantity() + 1);
    }
}
