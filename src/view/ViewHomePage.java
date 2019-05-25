package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.Tabs.JacketsTab;
import view.Tabs.PantsTab;
import view.Tabs.ShoesTab;
import view.Tabs.TshirtsTab;
import viewmodel.ViewModel;

import java.io.IOException;

public class ViewHomePage {

	private ViewModel viewModel;
	private MainView mainView;
	private PantsTab pants;
	private JacketsTab jackets;
	private ShoesTab shoes;
	private TshirtsTab tshirts;



	@FXML
	public void initialize(MainView mainView,ViewModel viewModel) {
		this.mainView = mainView;
		this.viewModel = viewModel;
		pants.init(viewModel);
		jackets.init(viewModel);
		shoes.init(viewModel);
		tshirts.init(viewModel);
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
