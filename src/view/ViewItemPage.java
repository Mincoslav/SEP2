package view;

import domain.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import viewmodel.ViewModel;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class ViewItemPage {

    @FXML
    private javafx.scene.image.ImageView picture;


    private ViewModel viewModel;

    @FXML
    private Button bag;

    @FXML
    private Button wishlist;

    @FXML
    public Label name;

    @FXML
    public Label price;

    @FXML
    public Label description;

    public MainView mainView;

    private Product product;

    @FXML
    public void init(ViewModel viewModel,MainView mainView) {
//        textArea.setEditable(false);
        this.mainView = mainView;
        this.viewModel = viewModel;
        product = viewModel.objectProperty();
        name.textProperty().bind(viewModel.nameItemProperty());
        price.textProperty().bind(viewModel.priceItemProperty());
        description.textProperty().bind(viewModel.descriptionItemProperty());
        picture.imageProperty().bind(viewModel.imageProperty());

      /*  theList.itemsProperty().bind(messagesViewModel.listProperty());
        textArea.textProperty().bind(messagesViewModel.msgProperty());*/
 }


    public void addToWishPressed(ActionEvent actionEvent) {
        Product product1 = product;
        viewModel.addToWishList(product1);
    }

    public void addToBagPressed(ActionEvent actionEvent) {
        Product product1 = product;
        viewModel.addToShoppinBag(product1);
    }

    public void returnToHome(ActionEvent actionEvent) {
        try {
            mainView.openView("Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
