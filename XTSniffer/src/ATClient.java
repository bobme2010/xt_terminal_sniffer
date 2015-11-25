
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

//这个是用来和XT terminal 通讯的代理程序，负责底层消息的发送

import com.xtc.util.Logs;

public class ATClient 
{	
	
	private static final int SOCKET_TIMEOUT = 3 * 1000; //default connection time out:3 seconds
	private static final int SOTIMEOUT = 1 * 1000; //default read time out:1 seconds

	private String _remoteIP = "N/A";
	private int    _remotePort =55003;
	
	private Socket _socket = null; //与XT Terminal 的tcp/ip连接
	
	public  void isXTDevice(String ip)
	{
		_remoteIP =ip;
		if(true==checkTerminalReachable()) 
		{	
			createSocketConnection();
		}
		else
			System.out.println("ip: " + ip + " is not reachable");

	}

	private void createSocketConnection()  {
		//启动Socket连接，创建读写端口
		try
		{
			this._socket= new Socket(); //必须新建socket
			this._socket.connect(new InetSocketAddress(_remoteIP,_remotePort),SOCKET_TIMEOUT);
			this._socket.setSoTimeout(SOTIMEOUT); 
			if(this._socket.isConnected())
				Logs.info("["+ _remoteIP  +"] is an xt terminal");
			
				
			this._socket.close();
		}
		catch(Exception e)
		{
			Logs.info("ip: " + _remoteIP + " is NOT an XT terminal");
		}
	}
	

	
	
	//test if remote terminal is reachable
	private boolean checkTerminalReachable()
	{
	    try
	    { 
	    	InetAddress address = InetAddress.getByName(_remoteIP);//ping this IP 
	    	
	    	if(address.isReachable(3000))	
				return true; //reset fail counter.
//			else
//			    Logs.info("["+ _remoteIP +"] is not reachable");       
       }catch(Exception e)
        {
//    	   Logs.info("["+ _remoteIP +"] checkTerminalReachable error: " + e.getMessage());       
        }
	    
	    return false;
	}
}
