/**
 *The Separator class takes number inputs and puts the integers in a list and the
 *float values in a separate list. Any non-number values end the input
 *
 *@author Evan Jameson
 *@version Lab 00
 */

import java.util.*;

public class Separator
{
	public static void main(String[] args)
	{
		int n = 6;
		ArrayList<Integer> ints = new ArrayList<Integer>(); 
		ArrayList<Float> floats = new ArrayList<Float>(); 
		Scanner s = new Scanner(System.in);
		while(true)
		{
			if(s.hasNextInt() == true)
			{
				if(ints.size() < n)
				{
					ints.add(s.nextInt());
				}
				else 
				{
					break;
				}
			}	
			else if(s.hasNextFloat() == true)
			{
				if(floats.size() < n)
				{
					floats.add(s.nextFloat());
				}
				else
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		s.close();
		System.out.print("\nIntegers:");
		print(ints);
                System.out.print("\nFloats:");
		print(floats);
		System.out.println();
	}

	public static <T> void print(ArrayList<T> array)
	{
		for(T element : array)
		{
			System.out.print(" " + element);
		}
	}
}
