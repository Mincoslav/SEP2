package view;

import javafx.fxml.FXML;
import viewmodel.ViewModel;

public class ViewHomePage {

	private ViewModel viewModel;
	private MainView mainView;

	@FXML
	public void initialize(MainView mainView,ViewModel viewModel) {
		this.mainView = mainView;
		this.viewModel = viewModel;
	}





}
