package view;

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
    public ImageView image;

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
