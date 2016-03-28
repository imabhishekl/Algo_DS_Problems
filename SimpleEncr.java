import java.util.Scanner;


public class SimpleEncr {
	public static void main(String[] arg)
	{
		Scanner cin = new Scanner(System.in);
		byte[] pass_txt = cin.next().getBytes();//.toCharArray();
		
		System.out.println("Original Text : " + (new String(pass_txt)));
		
		/* Convert from 16 bit char to 32 bit int */
		
		for(int i = 0;i < (pass_txt.length - 1);i++)
		{
			pass_txt[i] = (byte)(pass_txt[i] ^ pass_txt[i + 1]);
		}
		
		System.out.println("After Decode Text : " + (new String(pass_txt)));
		
		/* Decode now */
		for(int i = pass_txt.length - 2;i >= 0;i--)
		{
			pass_txt[i] = (byte)(pass_txt[i + 1] ^ pass_txt[i]);
		}
		System.out.println("After encode and decode : " + (new String(pass_txt)));
	}

}
