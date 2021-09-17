package application;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PasswordCheckerUtility extends java.lang.Object {

	public static boolean ifPasswordContainsSpecialSymbol(String str)
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(str);
		return (!matcher.matches());
	}
	
	public PasswordCheckerUtility()
	{
		
	}
	/**
	 
	 * @param passwordString - string to be checked for validity 
	 * @return - true if valid password, set up to return false if an invalid password, but throws an exception instead.
	 * @throws LengthException - thrown if length is less than 6 characters.
	 * @throws NoDigitException - thrown if no digit. 
	 * @throws NoUpperAlphaException - thrown if no uppercase alphabetic character in the user-inputed password. 
	 * @throws NoLowerAlphaException - thrown if no lowercase alphabetic character in the user-inputed password. 
	 * @throws InvalidSequenceException - thrown if more than 2 of the same character. 
	 * @throws NoSpecialCharacterException - thrown if a special character is in the user-inputed password.  
	 */

	public static boolean comparePasswordsWithReturn(String passwordString, String passwordConfirm) {
		if (passwordString.compareTo(passwordConfirm) == 0)
			return true;
		else
			return false;
	}
	public static boolean isValidPassword(String passwordString) throws  NoLowerAlphaException, LengthException,
	InvalidSequenceException, NoUpperAlphaException,  NoSpecialSymbolException ,
	NoDigitExeption, NoSpecialCharacterException
	{
		int firstCharacter = 1;
		int j = 0; 
		int password_Length = passwordString.length();
		int secondCharacter = 2;
		
		
		while(j < password_Length)
		{
			if((j+firstCharacter < password_Length) && (j+secondCharacter < password_Length)) 
			{
				while((passwordString.charAt(j) == passwordString.charAt(j+firstCharacter)) && (passwordString.charAt(j+firstCharacter) ==
					passwordString.charAt(j+secondCharacter)))
				{
					throw new InvalidSequenceException();		
				}	
			}
			
			j++;
		}
		
		Pattern specialCharacter = Pattern.compile("[a-zA-Z0-9]*");
		Pattern lower_Case = Pattern.compile("[a-z]");
		Pattern upper_Case = Pattern.compile("[A-Z]");
		
			
		while(!(specialCharacter.matcher(passwordString).find()))
		{
			throw new NoSpecialCharacterException();
		}
		
		Pattern number = Pattern.compile("[0-9]");	
		while(!(number.matcher(passwordString).find()))
		{
			throw new  NoDigitExeption();
		}
		
		while(passwordString.length() < 6)
		{
			throw new LengthException(); 
		}
		

			
		
		while(!(lower_Case.matcher(passwordString).find()))
		{
			throw new NoLowerAlphaException();
		}
		
		while(!(upper_Case.matcher(passwordString).find()))
		{
			throw new NoUpperAlphaException();
		}
		
		return true;	

	}
	
	/**
	 * @param passwordString - string to be checked if weak password. 
	 * @return - true if length of password is greater than or equal to 6 but less than or equal to 9. 
	 */
	public static boolean isWeakPassword(String passwordString)
	{
		int length_PasswordString = passwordString.length();
		
		boolean status = true;
		
		while (length_PasswordString >= 6 && length_PasswordString <= 9)
		{
			
			return status; 
			
		}
			
			status = false;
			
			return status; 
	}
	
	
	/** 
	 * @param passwords - arraylist of passwords to check for validity.
	 * @return - arraylist of invalid passwords. It will not return weak passwords. 
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		Exception exceptionThrown = null; //* setting the exception thrown to be null at beginning. 
		
		ArrayList<String> invalidPasswords = new ArrayList<String>(); /* used for returning invalid passwords (user-inputed). */
		
		boolean if_ValidSequence = true; 
		boolean ifUpperCase = false;
		boolean ifTheSpecialSymbol = false; 
		boolean ifLowerCase = false; 
		boolean the_Digit = false;
				
		for(String user_Password: passwords)
		{
			
			Pattern passwordisUpperCase = Pattern.compile("[A-Z]"); 
			Pattern ifPasswordIsDigit = Pattern.compile("[0-9]");
			Pattern passwordisLowerCase = Pattern.compile("[a-z]");  
			Pattern passwordisOfSpecialCharacter = Pattern.compile("[a-zA-Z0-9]*"); 
			
			if_ValidSequence = true;
			ifLowerCase = false;
			the_Digit = false;
			ifTheSpecialSymbol = false;
			ifUpperCase = false; 
			
			int lengthPassword = user_Password.length();
			
			exceptionThrown = null;		
			
			if(lengthPassword < 6)
			{
				exceptionThrown = new LengthException(); 
			}
			
			int k = 0;
			
			while(k < lengthPassword)
			{
				
				if(passwordisLowerCase.matcher(user_Password).find())
				{
					ifLowerCase = true;
				}
				
				if(ifPasswordIsDigit.matcher(user_Password).find())
				{
					the_Digit = true;  
				}
						
				if(passwordisUpperCase.matcher(user_Password).find())
				{
					ifUpperCase = true;
				}
				
				k++;
			}
			if(the_Digit && ifLowerCase && ifUpperCase && ifTheSpecialSymbol && if_ValidSequence)
			{	
				int i = 0;
				
				int theNextElement = i+1;
				int passwordByUser = user_Password.length()-1;
				int nextElement_AfterThat = i+2;
				
				
				while(i < passwordByUser)
				{
					if((user_Password.charAt(i) == user_Password.charAt(theNextElement)) && (user_Password.charAt(i) == user_Password.charAt(nextElement_AfterThat)))
					{
						if_ValidSequence = false;
					}
					i++;
				}				
			}
	
			if(ifPasswordContainsSpecialSymbol(user_Password))
			{
				ifTheSpecialSymbol = true; 
			}
			
			else if(!(if_ValidSequence))
			{
				exceptionThrown = new InvalidSequenceException();
			}
			else if(!(ifTheSpecialSymbol))
			{
				exceptionThrown = new NoSpecialCharacterException();
			}
			if(!(the_Digit))
			{
				exceptionThrown = new NoDigitExeption();
			}
			String s_Character = " ";
			if(exceptionThrown != null)
			{
				invalidPasswords.add(user_Password + s_Character + exceptionThrown.getMessage());
			}

			else if(!(ifLowerCase))
			{
				exceptionThrown = new NoLowerAlphaException();
			}

			else if(!(ifUpperCase))
			{
				exceptionThrown = new NoUpperAlphaException();
			}
		}
		
		return invalidPasswords; 
		

	}
	
}