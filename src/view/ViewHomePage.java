package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import view.Tabs.JacketsTab;
import view.Tabs.PantsTab;
import view.Tabs.ShoesTab;
import view.Tabs.TshirtsTab;
import viewmodel.ViewModel;

import java.io.IOException;

public class ViewHomePage {

    public Button wishlistButton;
    private ViewModel viewModel;
	private MainView mainView;
    @FXML
	public PantsTab pantsTab;
    @FXML
	public JacketsTab jacketsTab;
    @FXML
	public ShoesTab shoesTab;
    @FXML
	public TshirtsTab tshirtsTab;



	@FXML
	public void initialize(MainView mainView,ViewModel viewModel) {
		this.mainView = mainView;
		this.viewModel = viewModel;
	    jacketsTab.init(viewModel);
        pantsTab.init(viewModel);
        shoesTab.init(viewModel);
        tshirtsTab.init(viewModel);
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
