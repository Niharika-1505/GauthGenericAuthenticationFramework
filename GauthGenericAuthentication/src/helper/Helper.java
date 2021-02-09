package helper;

public class Helper
{
	public  static boolean checkCaptcha(String captcha,String code)
	{
		String str="";
		boolean status=false;
		String newCap[]=captcha.split(" ");
		for(int i=0;i<newCap.length;i++)
		{
			str=str+newCap[i];
		}
		if(str!=null&&code!=null)
		{
			if(str.equals(code))
			{
				status=true;
			}
			else
			{
				return false;
			}
		}
		return status;		
	}
	

}
