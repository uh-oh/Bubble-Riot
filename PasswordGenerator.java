import java.util.*;

public class PasswordGenerator
{

	private ArrayList<String> allowedCharacters = new ArrayList<String>();
	private character bunches = new character();
	private String newPassword = "";
	
	public PasswordGenerator()
	{
		//Do Nothing
	}
	
	public String generate(ArrayList<ArrayList<String>> a, int passwordSize)
	{
		//get characters permitted to be used
		for(int i =0; i<a.get(0).size();i++)
		{
            
			if(Integer.parseInt(a.get(1).get(i)) == 0)
			{
				//do nothing
			}
			else
			{
            
            int index = Integer.parseInt(a.get(0).get(i));
            String Allow = bunches.getValue(index);
			allowedCharacters.add(Allow);
			}
		}
		
		int l = allowedCharacters.size();
		
        newPassword = "";
		for(int k =0; k<passwordSize; k++)
		{
			int R = (int)(Math.random()*l);
			newPassword = newPassword + allowedCharacters.get(R);
		}
		
        allowedCharacters.clear();
		return newPassword;
		
	}
	
	
}
