
public class Validate {
	
	private int status;
	private boolean result;
	
	
	public  Validate()
	{
	}
	public boolean GetResult()
	{
		return this.result;
	}
	

	public int GetStatus()
	{
		return this.status;
	}
	
	public boolean validation()
	{
		//System.out.println("this.status"+this.status);
		//System.out.println("this.result"+this.result);
		return ((this.status==200) &&(this.result));
	}
	
	
	public String GetErrorMessage()
	{
		if ((this.status==200) &&(!this.result))
			return("Postcode not found");
		if (this.status==404)
			return("Empty input");
		else return ("Unrecognized Error");
	}

}
