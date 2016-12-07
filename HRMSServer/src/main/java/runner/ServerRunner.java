package runner;
import initial.DataBaseInit;
import rmi.RemoteHelper;

public class ServerRunner {
	
	public ServerRunner(){
		new RemoteHelper();
	}

	public static void main(String[] args) {
		ServerRunner s=new ServerRunner();
		new DataBaseInit();
	}
	
	void test5(){
		
	}

}
