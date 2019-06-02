package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.stage.Window;
import view.Tabs.JacketsTabController;
import view.Tabs.PantsTabController;
import view.Tabs.ShoesTabController;
import view.Tabs.TshirtsTabController;
import viewmodel.ViewModel;


import java.io.IOException;

public class ViewHomePage {

    public Button wishlistButton;
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

    /*@FXML
	private PantsTabController pantsTabController;
    @FXML
	private JacketsTabController jacketsTabController;
    @FXML
	private ShoesTabController shoesTabController;
    @FXML
	private TshirtsTabController tshirtsTabController;*/





	@FXML
	public void initialize(MainView mainView,ViewModel viewModel) {
		this.mainView = mainView;
		this.viewModel = viewModel;

     	/*jacketsTabController.init(viewModel,this);
     	pantsTabController.init(viewModel);
     	shoesTabController.init(viewModel);
     	tshirtsTabController.init(viewModel);*/
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
}
