package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import view.Tabs.JacketsTabC;
import view.Tabs.PantsTabC;
import view.Tabs.ShoesTabC;
import view.Tabs.TshirtsTabC;
import viewmodel.ViewModel;

import java.io.IOException;

public class ViewHomePage {

    public Button wishlistButton;
   
	public Tab jackets;
	public Tab pants;
	public Tab shoes;
	public Tab tshirts;
	private ViewModel viewModel;
	private MainView mainView;

    @FXML
	private PantsTabC pantsTabC;
    @FXML
	private JacketsTabC jacketsTabC;
    @FXML
	private ShoesTabC shoesTabC;
    @FXML
	private TshirtsTabC tshirtsTabC;



	@FXML
	public void initialize(MainView mainView,ViewModel viewModel) {
		this.mainView = mainView;
		this.viewModel = viewModel;

     	/*jacketsTabC.init(viewModel,this);
     	pantsTabC.init(viewModel);
     	shoesTabC.init(viewModel);
     	tshirtsTabC.init(viewModel);*/
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
