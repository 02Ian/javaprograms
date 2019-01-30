import java.util.*;
	
	class hash
	{
		public static void main(String[] args)
		{
			HashMap h = new HashMap();
			h.put(100,"MOHIT ATHANI");   // Inital valus of each key
			h.put(102,"NIKET");   // Inital valus of each key
			h.put(103,"NEHAL ATHANI");   // Inital valus of each key
			h.put(104,"HARSHALA ATHANI");   // Inital valus of each key
			
			System.out.println(h);
			System.out.println(h.put(102,"NIKET ATHANI 1")); //for change of value 
			
			Set s = h.keySet();	//Returns keys
			System.out.println(s);
			
			Collection c = h.values();	//Returns Values 
			System.out.println(c);
			
			Set s1 = h.entrySet();
			System.out.println(s1);
			
			Iterator itr = s1.iterator();
			while(itr.hasNext())
			{
				Map.Entry m1 = (Map.Entry)itr.next();
				System.out.println(m1.getKey()+ "....." +m1.getValue());
					if(m1.getKey().equals(102))
					{
						m1.setValue("NIKET ATHANI");
					}
			}
			System.out.println(h);
		}
	}