package view.ShoppingBagPage;
import domain.Product;
import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import view.MainView;
import viewmodel.ViewModel;

import java.io.IOException;

public class ViewShoppingBagPage {
    public Button removeButt;
    public Button decreaseButt;
    public Button increaseButt;
    public ViewModel viewModel;
    public ListView listBag;
    public Button checkout;
    public Label priceLabel;
    public Button returnToHome;

    private MainView mainView;
    private SimpleListProperty<Product> temp_list;

    @FXML
    public void init(ViewModel viewModel, MainView mainView) {
        temp_list = new SimpleListProperty<>();
        this.viewModel = viewModel;
        this.mainView = mainView;
        temp_list.bind(viewModel.simpleListProperty());
        listBag.itemsProperty().bind(viewModel.simpleListPropertyString());
        priceLabel.textProperty().bind(viewModel.priceProperty());
        checkout.setDisable(viewModel.getBag().size() == 0);


    }

    public void removeItem(ActionEvent actionEvent) {
        int index = listBag.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            listBag.getItems().remove(index);
            System.out.println(viewModel.getBag().size());
            viewModel.removeFromShoppingBag(viewModel.getBag().getProduct(index));
            System.out.println(viewModel.getBag().size());

        }


        checkout.setDisable(viewModel.getBag().size() == 0);
        priceLabel.setDisable(viewModel.getBag().size() == 0);

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
        Product prod = (Product) temp_list.get(index);
        System.out.println(index);
        System.out.println(viewModel.getBag().getProduct(index).getPurchasedQuantity());
        viewModel.decreasePurchasedQuantity(index);
        System.out.println(viewModel.getBag().getProduct(index).getPurchasedQuantity());
    }

    public void increase(ActionEvent actionEvent) {
        int index = listBag.getSelectionModel().getSelectedIndex();
        Product prod = (Product) temp_list.get(index);
        System.out.println(index);
        System.out.println(viewModel.getBag().getProduct(index).getPurchasedQuantity());
        viewModel.increasePurchasedQuantity(index);
        System.out.println(viewModel.getBag().getProduct(index).getPurchasedQuantity());
    }

    public void returnHomePage(ActionEvent actionEvent) {
        try {
            mainView.openView("Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
