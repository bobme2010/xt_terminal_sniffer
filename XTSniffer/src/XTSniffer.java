
public class XTSniffer
{

	int A1=  192;//135;
	int A2 = 168;//27;
	int A3 = 22;
	int A4 = 0;

	
	public static void main(String[] args) throws Exception 
	{
		XTSniffer xtSniffer = new XTSniffer();
		
		int a1 = Integer.parseInt(args[0]);
		int a2 = Integer.parseInt(args[1]);
		int a3 = Integer.parseInt(args[2]);
		int a4 = Integer.parseInt(args[3]);
		
		
		xtSniffer.excuteTest(a1,a2,a3,a4);
	}
	
	
	public  XTSniffer()
	{
		
	}
	
	public void excuteTest(int a1,int a2,int a3, int a4)
	{
		ATClient client = new ATClient();
		
		
		for (int i=a1;i<=256;i++)
		{
			A1 = i;
			for(int j =a2; j<256 ;j++)
			{
				A2=j;
				for(int k=a3;k<256;k++)
				{
					A3 =k;
					for(int l=a4;l<256;l++)
					{
						A4 = l;
						String ip = A1 + "." + A2 + "." + A3 + "." + A4;
						client.isXTDevice(ip);
						//safeSleep();
					}
				}
			}
		}
	}
	
	private void safeSleep()
	{
		try{
			Thread.sleep(500);
			//this.wait(100) ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
