package helper;

public class PasswordGenerator {
public String passwordgen()
{
String data="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
String str="";
char ch[]=data.toCharArray();
for(int i=0;i<8;i++)
{
	int j=(int)((Math.random())*62);
	str=str+ch[j];
}
return str;
}

}




