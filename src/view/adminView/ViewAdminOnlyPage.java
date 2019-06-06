package view.adminView;

import domain.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.ViewAlternativeHomePage;
import viewmodel.ViewModel;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ViewAdminOnlyPage {
    public ListView list;
    @FXML
    private Button removeButton;
    @FXML
    private TextField name;
    @FXML
    private TextField description;
    @FXML
    private TextField image;
    @FXML
    private CheckBox onSale;
    @FXML
    private ChoiceBox<String> category;
    @FXML
    private TextField quantity;
    @FXML
    private Button addSave;
    @FXML
    private TextField price;
    @FXML
    private TextField id;
    private ViewModel viewModel;



    public void initialize(ViewModel viewModel) {
        this.viewModel = viewModel;
        try {
            viewModel.getAllProducts();
            name.setTooltip(new Tooltip("Product name"));
            description.setTooltip(new Tooltip("Product description"));
            image.setTooltip(new Tooltip("Image URL"));
            id.setTooltip(new Tooltip("Product ID"));
            quantity.setTooltip(new Tooltip("Product current stock"));
            price.setTooltip(new Tooltip("Product price"));
            onSale.setTooltip(new Tooltip("Sale status"));
            category.setTooltip(new Tooltip("Choose a category"));
            addSave.setTooltip(new Tooltip("Save Changes/Add new Product"));
            removeButton.setTooltip(new Tooltip("Remove Selected Product"));
            list.setTooltip(new Tooltip("Click twice to choose a product"));
            list.itemsProperty().bind(viewModel.adminListProperty());

            category.getItems().add(0,"Tshirts");
            category.getItems().add(1,"Pants");
            category.getItems().add(2,"Shoes");
            category.getItems().add(3,"Jackets");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        list.itemsProperty().bind(viewModel.adminListProperty());
    }



    public void addProductMButton(ActionEvent actionEvent) throws RemoteException, SQLException, ClassNotFoundException {

        String namePro = name.getText();
        int proID = Integer.parseInt(id.getText().trim());
        String url = image.getText();
        int categoryID = category.getItems().indexOf(category.getSelectionModel().getSelectedItem())+1;
        int stock = Integer.parseInt(quantity.getText().trim());
        String descriptionPro = description.getText();
        double pricePro = Double.parseDouble(price.getText().trim());
        boolean onSaleStatus = onSale.isSelected();
        Product product  = new Product(namePro,url,proID,categoryID,stock,pricePro,onSaleStatus,descriptionPro,0);
        list.getItems().clear();
        viewModel.adminListProperty().clear();
        name.clear();
        image.clear();
        description.clear();
        id.clear();
        price.clear();
        quantity.clear();




        try {
            viewModel.addProduct(product);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        viewModel.getAllProducts();

    }

    public void removeProduct(ActionEvent actionEvent) throws RemoteException, SQLException, ClassNotFoundException {
        String namePro = name.getText();
        int proID = Integer.parseInt(id.getText().trim());
        String url = image.getText();
        int categoryID = category.getItems().indexOf(category.getSelectionModel().getSelectedItem())+1;
        int stock = Integer.parseInt(quantity.getText().trim());
        String descriptionPro = description.getText();
        double pricePro = Double.parseDouble(price.getText().trim());
        boolean onSaleStatus = onSale.isSelected();

        Product product  = new Product(namePro,url,proID,categoryID,stock,pricePro,onSaleStatus,descriptionPro,0);
        list.getItems().clear();

        viewModel.adminListProperty().clear();
        name.clear();
        image.clear();
        description.clear();
        id.clear();
        price.clear();
        quantity.clear();




        try {
            viewModel.removeProduct(product);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        viewModel.getAllProducts();
    }

    public void mouseClick(MouseEvent mouseEvent) {
        int i = mouseEvent.getClickCount();
        if(i==2 && !(list.getSelectionModel().isEmpty())){
            int index = list.getSelectionModel().getSelectedIndex();
            try {
                viewModel.getAProduct(viewModel.getAllProductsNoListener().get(index));
                name.setText(viewModel.objectProperty().getName());
                image.setText(viewModel.objectProperty().getImageLocation());
                description.setText(viewModel.objectProperty().getDescription());
                quantity.setText(viewModel.objectProperty().getQuantity()+"");
                id.setText(viewModel.objectProperty().getProductID()+"");
                category.getSelectionModel().select(viewModel.objectProperty().getCategoryID()-1);
                onSale.setSelected(viewModel.objectProperty().isOnSale());
                price.setText(viewModel.objectProperty().getPrice()+"");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }}



        }
}
