package view;

import domain.Product;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import viewmodel.ViewModel;

import javax.swing.text.html.ImageView;

public class ViewItemPage {

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

    @FXML
    private ImageView image;

    private SimpleObjectProperty<Product> product;

    @FXML
    public void init(ViewModel viewModel) {
//        textArea.setEditable(false);
        this.viewModel = viewModel;
      /*  theList.itemsProperty().bind(messagesViewModel.listProperty());
        textArea.textProperty().bind(messagesViewModel.msgProperty());*/
 }


    public void addToWishPressed(ActionEvent actionEvent) {

    }

    public void addToBagPressed(ActionEvent actionEvent) {

    }
}
