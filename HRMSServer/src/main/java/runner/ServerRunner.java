package runner;
import initial.DataBaseInit;
import rmi.RemoteHelper;

public class ServerRunner {

	public ServerRunner(){
		new RemoteHelper();
	}

	public static void main(String[] args) {
		new DataBaseInit();
		new ServerRunner();
	}



}
