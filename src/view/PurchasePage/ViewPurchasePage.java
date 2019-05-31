package view.PurchasePage;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import view.MainView;
import viewmodel.ViewModel;

import java.io.IOException;

public class ViewPurchasePage {

    public TextField address;
    public TextField phone;
    public Button pay;
    public TextField name;
    private ViewModel viewModel;
    private MainView mainView;

    public void init(ViewModel viewModel, MainView mainView) {

        this.viewModel = viewModel;
        this.mainView = mainView;
        pay.setDisable(false);

    }

    public void finnishPurchase(ActionEvent actionEvent) {
        String coName = name.getText();
        String coAddress = address.getText();
        int coPhone = Integer.parseInt(phone.getText());
        try {
            System.out.println(coPhone);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException is handled");}


        viewModel.purchase(coName,coAddress,coPhone);
        name.clear();
        address.clear();
        phone.clear();
        try {
            mainView.openView("Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleKeyReleased1(KeyEvent keyEvent) {
        String text = name.getText();
        boolean disableButton = text.isEmpty() | text.trim().isEmpty();
        pay.setDisable(disableButton);
    }

    public void handleKeyReleased2(KeyEvent keyEvent) {
        String text = address.getText();
        boolean disableButton = text.isEmpty() | text.trim().isEmpty();
        pay.setDisable(disableButton);
    }

    public void handleKeyReleased3(KeyEvent keyEvent) {
        String text = phone.getText();
        boolean disableButton = text.isEmpty() | text.trim().isEmpty();
        pay.setDisable(disableButton);
    }

    public void returnToBag(ActionEvent actionEvent) {
        try {
            mainView.openView("ShoppingBag");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
