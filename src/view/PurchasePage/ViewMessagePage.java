package view.PurchasePage;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import view.MainView;
import viewmodel.ViewModel;

import java.io.IOException;

public class ViewMessagePage {


    public Label orderID;
    private ViewModel viewModel;
    private MainView mainView;

    public void init(ViewModel viewModel, MainView mainView){
        this.viewModel = viewModel;
        this.mainView = mainView;
        orderID.textProperty().bind(viewModel.orderIDProperty());
    }

    public void mouseClick(MouseEvent mouseEvent) {
        int i = mouseEvent.getClickCount();
        if(i==2 ){
            try {
                mainView.openView("Home");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
