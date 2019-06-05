package view;

import domain.Categories;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import viewmodel.ViewModel;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ViewAlternativeHomePage {


    public Button bagButton;
    @FXML
    private Button wishlistButton;
    @FXML
    private Button prevOrderButton;
    @FXML
    private ImageView image1;
    @FXML
    private Label label6;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image4;
    @FXML
    private Label label1;
    @FXML
    private Label label5;
    @FXML
    private Button previousButt;
    @FXML
    private Button nextButt;

    private MainView mainView;

    private ViewModel viewModel;
    private int page;
    private boolean buttons;
    private String current_Category;
    private int current_Category_ID;


    @FXML
    public void initialize(MainView mainView, ViewModel viewModel) {
        page=1;
        current_Category = "Jackets" ;
        current_Category_ID = 4;

        this.mainView = mainView;
        this.viewModel = viewModel;
        try {
            viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page);
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

        image1.imageProperty().bind(viewModel.image_1Property());
        image1.imageProperty().bind(viewModel.image_2Property());
        image1.imageProperty().bind(viewModel.image_3Property());
        image1.imageProperty().bind(viewModel.image_4Property());
        image1.imageProperty().bind(viewModel.image_5Property());
        image1.imageProperty().bind(viewModel.image_6Property());


        buttons = (page == 1);

    }


    public void clickWishlist(ActionEvent actionEvent) {
        try {
            mainView.openView("WishList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickBagButton(ActionEvent actionEvent) {
        try {
            mainView.openView("ShoppingBag");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oldOrdersButton(ActionEvent actionEvent) {
        try {
            mainView.openView("Orders");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void prevPressed(ActionEvent actionEvent) {
        page--;
        previousButt.setDisable(buttons);
        try {
            viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page); ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void nextPressed(ActionEvent actionEvent) throws RemoteException, SQLException, ClassNotFoundException {
        page ++;
        previousButt.setDisable(buttons);
        viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page);
    }

    public void jacketsPage(ActionEvent actionEvent) throws RemoteException, SQLException, ClassNotFoundException {
        current_Category = "Jackets" ;
        current_Category_ID = 4;
        viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page);


    }

    public void shoesPage(ActionEvent actionEvent) throws RemoteException, SQLException, ClassNotFoundException {
         current_Category = "Shoes" ;
         current_Category_ID = 3;
         viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page);


    }

    public void tshirtsPage(ActionEvent actionEvent) throws RemoteException, SQLException, ClassNotFoundException {
        current_Category = "Tshirts" ;
        current_Category_ID = 1;
        viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page);
    }

    public void pantsButton(ActionEvent actionEvent) {
        current_Category = "Pants" ;
        current_Category_ID = 2;
        try {
            viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void labelClick(MouseEvent mouseEvent) {
        try {
            viewModel.getAProduct(viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page).get(0));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            mainView.openView("Item");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void labelClick2(MouseEvent mouseEvent) {
        try {
            viewModel.getAProduct(viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page).get(1));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            mainView.openView("Item");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void labelClick3(MouseEvent mouseEvent) {
        try {
            viewModel.getAProduct(viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page).get(2));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            mainView.openView("Item");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } public void labelClick4(MouseEvent mouseEvent) {
        try {
            viewModel.getAProduct(viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page).get(3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            mainView.openView("Item");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void labelClick5(MouseEvent mouseEvent) {
        try {
            viewModel.getAProduct(viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page).get(4));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            mainView.openView("Item");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void labelClick6(MouseEvent mouseEvent) {
        try {
            viewModel.getAProduct(viewModel.getProductsPerPagePerCategory(new Categories(current_Category_ID,current_Category),page).get(5));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            mainView.openView("Item");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
