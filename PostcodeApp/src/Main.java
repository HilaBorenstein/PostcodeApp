import java.io.IOException;

public class Main {
	/*************************************
	 * MAIN
	 * @param args
	 * @throws IOException 
	 ************************************/
	
	public static void main(String[] args) throws IOException {
		

		
		
		String input=args[0];
		PostcodeParser ps1= new PostcodeParser(input);
		ps1.GetPostcodeJsonData();
		System.out.print(ps1);
		
		
		//For myself
	/*
		String [] lst= {"BS34 7NP","DD2 5AU","CB3 0FA","CF10 1AA", "M32 0JG","DD2 5AU","SW1W 0NY", "PO16 7GZ", "GU16 7HF","DD2 5AW",  "CF10 1AB","DD2 5AX","BT10 9BJ"};
		//String [] lst2= {"DD2 5AU","CB3 0FA","OX49 5NU", "M32 0JG", "NE30 1DP","DD2 5AU","SW1W 0NY", "PO16 7GZ", "GU16 7HF","DD2 5AW",  "L1 8JQ","DD2 5AX"};
		
		for (int i = 0; i <lst.length; i++)
		{
			PostcodeParser ps= new PostcodeParser(lst[i]);
			if(ps.ValidatePostcode())
			{
				ps.GetPostcodeJsonData();
				System.out.print(ps); 
			}
		}
		
		
		PostcodeParser ps= new PostcodeParser("CB3 0FA");
		if(ps.ValidatePostcode())
		{
			ps.GetPostcodeJsonData();
			System.out.print(ps); 
		}

		
		*/
		

	}
}
