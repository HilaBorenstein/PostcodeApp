
/******************************
 * This class holds PostcodeObject
 * 
 * 
 * @author Borenstein
 *
 */

public class PostcodeObject {
	
	private int status;
	private Result result;
	
	public PostcodeObject() {}
	
	public Result GetResult()
	{
		return this.result;
	}
	
	public int GetStatus()
	{
		return this.status;
	}
	
	
	public boolean validation()
	{
		return(this.status==200 );
	}
	
	

}
