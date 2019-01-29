import java.util.*;
class issueMovieTicket{
	public static void main(String[] args)
	{
		try{
		String[] moviesOnShow=new String[3];
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Scanner br=new Scanner(System.in);
		for(int i=0;i<=moviesOnShow.length;i++)
		{
			moviesOnShow[i]=br.nextLine();
		}
		for(int i=0;i<=moviesOnShow.length;i++)
		{
			System.out.print("Movies on Shows \t "+moviesOnShow[i]);
			System.out.print("#");
		}	
		}catch(Exception E){}
	}
}