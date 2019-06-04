package view.PreviousOrdersPAge;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.MainView;
import viewmodel.ViewModel;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ViewPreviousOrders {
    public TextField fieldz;
    public Button findOrderButton;
    public Label name;
    public Button returnButton;
    public Label date;
    public Label price;
    private ViewModel viewModel;
    private MainView mainView;


    public void init(ViewModel viewModel, MainView mainView) {
        this.viewModel = viewModel;
        this.mainView = mainView;

    }

    public void findOrderAct(ActionEvent actionEvent) {
        int id = Integer.parseInt(fieldz.getText());
        try{
            name.setText("Costumer:  " + viewModel.finOrderByID(id).getCostumerName());
            price.setText("Price:  " + viewModel.finOrderByID(id).getShoppingBag().subTotal());
            date.setText("Date:  "  + viewModel.finOrderByID(id));
        } catch (NumberFormatException | RemoteException | SQLException e) {
        System.out.println("NumberFormatException is handled");}
    }

    public void returnToHome(ActionEvent actionEvent) {
        try {
            mainView.openView("Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
