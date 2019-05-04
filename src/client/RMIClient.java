package client;

import mediator.Model;
import server.RServer;

public class RMIClient implements Client, RClient {

	private Model model;

	private RServer rServer;

}
