package view.Tabs;

import domain.Categories;
import domain.Product;
import domain.Products;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import viewmodel.ViewModel;

import java.util.ArrayList;


public class JacketsTab {

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







    @FXML
    public void init(ViewModel viewModel) {
        this.viewModel = viewModel;
        ArrayList<Product> listOfProducts = null;
        ArrayList<Product> displayedProducts = null;
        listOfProducts = viewModel.getCategories(new Categories(1,"Jackets"));
        for(int i = 0; i < 6 && i < listOfProducts.size();i++){
            displayedProducts.add(listOfProducts.get(i));
        }
        if(!displayedProducts.get(0).equals(null))
        label1.setText(displayedProducts.get(0).getName());
        image1.setImage();


    }
}
