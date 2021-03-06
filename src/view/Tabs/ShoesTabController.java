package view.Tabs;

import domain.Categories;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import viewmodel.ViewModel;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class ShoesTabController {

    @FXML
    private AnchorPane shoesTab;
    private ViewModel viewModel;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    private int page;

    @FXML
    private Button previousButt;
    @FXML
    private Button nextButt;
    private boolean buttons;

    @FXML
    public void init(ViewModel viewModel) {
        page = 1;
        this.viewModel = viewModel;
        try {
            viewModel.getProductsPerPagePerCategory(new Categories(3,"Shoes"),page);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        label1.textProperty().bind(viewModel.label_1Property());
        label2.textProperty().bind(viewModel.label_2Property());
        label3.textProperty().bind(viewModel.label_3Property());
        label4.textProperty().bind(viewModel.label_4Property());
        label5.textProperty().bind(viewModel.label_5Property());
        label6.textProperty().bind(viewModel.label_6Property());

        buttons = (page == 1);
        previousButt.setDisable(buttons);
    }

    public void prevPressed(ActionEvent actionEvent) {
        page--;
        previousButt.setDisable(buttons);
        try {
            viewModel.getProductsPerPagePerCategory(new Categories(3,"Shoes"),page);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        label1.textProperty().bind(viewModel.label_1Property());
        label2.textProperty().bind(viewModel.label_2Property());
        label3.textProperty().bind(viewModel.label_3Property());
        label4.textProperty().bind(viewModel.label_4Property());
        label5.textProperty().bind(viewModel.label_5Property());
        label6.textProperty().bind(viewModel.label_6Property());
    }

    public void nextPressed(ActionEvent actionEvent) {
        page--;
        previousButt.setDisable(buttons);
        try {
            viewModel.getProductsPerPagePerCategory(new Categories(3,"Shoes"),page);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        label1.textProperty().bind(viewModel.label_1Property());
        label2.textProperty().bind(viewModel.label_2Property());
        label3.textProperty().bind(viewModel.label_3Property());
        label4.textProperty().bind(viewModel.label_4Property());
        label5.textProperty().bind(viewModel.label_5Property());
        label6.textProperty().bind(viewModel.label_6Property());
    }
}
