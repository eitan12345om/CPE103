/**
 *The ListWork class is used to build a list of 10
 *integers and once that has been completed, the list can be searched
 *for any number. There is InputMismatchExeption hendling as well
 *
 *@author Evan Jameson
 *@version Lab 00
 */


import java.util.*;
import java.util.InputMismatchException;

public class ListWork
{
	public static void main(String[] args)
	{
		Integer[] ints = new Integer[10];
		Scanner s = new Scanner(System.in);
		System.out.print("Enter 10 Integers: \n");
		for(int i = 0; i < 10; i++)
		{
			try
			{
				ints[i] = s.nextInt();
			}
			catch(InputMismatchException e)
			{
				s.next();
				i--;	
			}
			if(ints[9] != null)
			{
				break;
			}			
		}
		if(ints[9] != null)
		{
			s.nextLine();
			while(ints[9] != null)
			{
				System.out.print("Would you like to search for a number yes/no?\n");
                                String input = s.next();
				if(input.equals("yes") || input.equals("y"))
				{
					System.out.print("What number are you looking for? \n");
					try
					{
						Integer searchNum = new Integer(s.nextInt());
						System.out.print(search(ints, searchNum) + "\n");
					}
					catch(Exception e)
					{
						System.out.print("Error: Non-integer target entered\n");
						//break;
					}
				}
				else if(input.equals("no"))
				{
					break;
				}	
			}
		print(ints);
		}
		
	}

	public static <T> void print(T[] arr)
	{
		for(T element : arr)
		{
			System.out.print(element +  "\n");
		}
	}

	public static <T> boolean search(T[] arr, T target)
	{
		for(T element : arr)
		{
			if(target == null || element == null)
			{
				if(target == element)
				{
					return true;
				}
			}
			else if(element.equals(target))
			{
				return true;
			}
		}
		return false;
	}
}
