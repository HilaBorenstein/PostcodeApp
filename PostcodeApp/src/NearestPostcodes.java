
import java.util.ArrayList;


/*************************************************
 * This class holds arraylist of nearest postcodes
 * 
 * @author Borenstein
 ***
 *************************************************/

public class NearestPostcodes {
	
	private int status;
	private ArrayList<Result> result;
	
	public NearestPostcodes  ()
	{
	}
	
	ArrayList<Result> GetResult()
	{
		return this.result;
	}
	
	public int GetStatus()
	{
		return this.status;
	}
	
	public boolean validation()
	{
		return (this.status==200);
	}
	
	public void UpdateNullRegion() {
		for(Result tmp: result)
		{
			tmp.updateRegion();
		}
		    }
	
	public String GetErrorMessage()
	{
		if ((this.status!=200) )
			return("Postcode not found");
		else return ("Unrecognized Error");
	}
	
	
	public String  toString ()
	{
		StringBuilder s=new StringBuilder();
		s.append("*List Of The Nearest Postcodes:* \n");
		for(Result tmp: result)
		{
			s.append(tmp+"\n");
		}
		return	(s.toString());
	}
}
