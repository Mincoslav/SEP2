package view.Tabs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Window;
import view.MainView;
import viewmodel.ViewModel;


import java.io.IOException;

public class ViewHomePage {

    public Button wishlistButton;
	public Button prevOrderButton;
	public ImageView image1;
	public Label label6;
	public ImageView image2;
	public ImageView image3;
	public Label label2;
	public Label label3;
	public Label label4;
	public ImageView image5;
	public ImageView image6;
	public ImageView image4;
	public Label label1;
	public Label label5;
	public Button previousButt;
	public Button nextButt;
	private ViewModel viewModel;
	private MainView mainView;

	@FXML
	private Window pantsTab;

	@FXML
	private Window jacketsTab;
	@FXML
	private Window shoesTab;
	@FXML
	private Window tshirtsTab;

    @FXML
	private PantsTabController pantsTabController;
    @FXML
	private JacketsTabController jacketsTabController;
    @FXML
	private ShoesTabController shoesTabController;
    @FXML
	private TshirtsTabController tshirtsTabController;






	@FXML
	public void initialize(MainView mainView,ViewModel viewModel) {
		this.mainView = mainView;
		this.viewModel = viewModel;

     	jacketsTabController.init(viewModel);
     	pantsTabController.init(viewModel);
     	shoesTabController.init(viewModel);
     	tshirtsTabController.init(viewModel);
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
    }

	public void nextPressed(ActionEvent actionEvent) {
	}

	public void jacketsPage(ActionEvent actionEvent) {
	}

	public void shoesPage(ActionEvent actionEvent) {
	}

	public void tshirtsPage(ActionEvent actionEvent) {
	}

	public void pantsButton(ActionEvent actionEvent) {
	}
}
