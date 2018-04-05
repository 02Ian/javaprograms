import java.util.*;
import java.io.*;
import java.security.MessageDigest;

class PasswordValidator  
{
        public PasswordValidator()
        {
                super();
        }

        public static void main(String[] args)throws Exception
        {
                PasswordValidator passwordValidator = new PasswordValidator();
				
				Scanner scr=new Scanner(System.in);
				
				System.out.println("Enter the username");
				String userName=scr.next();
				
				System.out.println("Enter the password");
				String passWord=scr.next();
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(passWord.getBytes());
 
				byte byteData[] = md.digest();
	
				//convert the byte to hex format method 1
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
 
			
				//convert the byte to hex format method 2
				StringBuffer hexString = new StringBuffer();
				for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
				
				}
				String Pass =  new String(hexString);
        System.out.println("Digest(in hex format):: " +Pass);

                System.out.println("USERNAME AND PASSWORD HAVE BEEN SAVED");
               
                passwordValidator.passwordValidation(userName,passWord);				
				
				try{
						BufferedWriter br=new BufferedWriter(new FileWriter(".//text.txt"));
						br.write("username : ");
						br.write(userName );
						br.newLine();
						br.newLine();
						br.write("Password : ");
						br.write(Pass);
						br.close();
							
					
					}catch(IOException e){
											e.printStackTrace();
										 }
										 
										 
				
        }
		
        /*
         * Password should be less than 15 and more than 8 characters in length.
         * Password should contain at least one upper case and one lower case alphabet.    
         * Password should contain at least one number.
         * Password should contain at least one special character.
         */


        public void passwordValidation(String userName, String password)
        {
                boolean valid = true;
                if (password.length() > 15 || password.length() < 8)
                {
                        System.out.println("Password should be less than 15 and more than 8 characters in length.");
                        valid = false;
                }
                if (password.indexOf(userName) > -1)
                {
                        System.out.println("Password Should not be same as user name");
                        valid = false;
                }
                String upperCaseChars = "(.*[A-Z].*)";
                if (!password.matches(upperCaseChars ))
                {
                        System.out.println("Password should contain atleast one upper case alphabet");
                        valid = false;
                }
                String lowerCaseChars = "(.*[a-z].*)";
                if (!password.matches(lowerCaseChars ))
                {
                        System.out.println("Password should contain atleast one lower case alphabet");
                        valid = false;
                }
                String numbers = "(.*[0-9].*)";
                if (!password.matches(numbers ))
                {
                        System.out.println("Password should contain atleast one number.");
                        valid = false;
                }
                String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
                if (!password.matches(specialChars ))
                {
                        System.out.println("Password should contain atleast one special character");
                        valid = false;
                }
                if (valid)
                {
                        System.out.println("Password is valid.");
                }
        }
}