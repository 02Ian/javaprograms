import java.util.*;
import java.io.*;

class Bayes
{
public static void main(String args[])
{ 
	int i,b,count_by=0,count_bn=0, count_aby=0,count_abn=0,count_iby=0,count_ibn=0,count_sby=0,count_sbn=0;
	float buys_y,buys_n,page_yes,page_no,pincome_yes,pincome_no,pstudent_yes,pstudent_no,pyes,pno;
	
	char age[]={'y','y','m','s','s','s','m','y','y','s','y','m','m','s'};
	char income[]={'h','h','h','m','l','l','l','m','l','m','m','m','h','m'};
	char student[]={'n','n','n','n','y','y','y','n','y','y','y','n','y','n'};
	char buys[]={'n','n','y','y','y','n','y','n','y','y','y','y','y','n'};
	
	b=age.length;
	for(i=0;i<b;i++)
	{
		if(buys[i]=='y')
		{
			count_by++;
		}else
		{
			count_bn++;
		}
	}
	buys_y=(float)count_by/b;
	buys_n=(float)count_bn/b;
	System.out.println("Probability of Buys yes = "+buys_y);
	System.out.println("Probability of Buys no = "+buys_n);
	
	System.out.println("Enter a Tuple");
	Scanner sc = new Scanner(System.in);
	String s= sc.nextLine();
	char req[]=s.toCharArray();
	for(i=0;i<b;i++)
	{
		if(age[i]==req[0] && buys[i]=='y')
		{
			count_aby++;
		}
		if(age[i]==req[0] && buys[i]=='n')
		{
			count_abn++;
		}
		if(income[i]==req[1] && buys[i]=='y')
		{
			count_iby++;
		}
		if(income[i]==req[1] && buys[i]=='n')
		{
			count_ibn++;
		}
		if(student[i]==req[2] && buys[i]=='y')
		{
			count_sby++;
		}
		if(student[i]==req[2] && buys[i]=='n')
		{
			count_sbn++;
		}
		

	}
	
	page_yes=(float)count_aby/count_by;
	page_no=(float)count_abn/count_bn;
	pincome_yes=(float)count_iby/count_by;
	pincome_no=(float)count_ibn/count_bn;
	pstudent_yes=(float)count_sby/count_by;
	pstudent_no=(float)count_sbn/count_bn;

	System.out.println("Probability of Age=Youth/Buys=yes = "+page_yes);
	System.out.println("Probability of Age=Youth/Buys=no = "+page_no);
	System.out.println("Probability of income=Medium/Buys=yes = "+pincome_yes);
	System.out.println("Probability of income=Medium/Buys=no = "+pincome_no);
	System.out.println("Probability of student=yes/Buys=yes = "+pstudent_yes);
	System.out.println("Probability of student=yes/Buys=no = "+pstudent_no);

	pyes = (page_yes)*(pincome_yes)*(pstudent_yes);
	pno = (page_no)*(pincome_no)*(pstudent_yes);

	System.out.println(" ");
	System.out.println("Probability of X/Buys=yes"+pyes);
	System.out.println("Probability of X/Buys=yes"+pno);

	if(pyes>pno)
	{
		System.out.println("Yes is the final Class");
	}
	else
	{
		System.out.println("No is the final Class");
	}
		
}
}
