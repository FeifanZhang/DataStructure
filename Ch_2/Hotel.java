package ตฺถþีย;

import java.util.Scanner;
//2.28
public class Hotel 
{
	String[] name;
	public Hotel()
	{
		name=new String[10];
		for(int i=0;i<name.length;i++)
		{
			name[i]="null";
		}
	}
	
	public void checkIn(String Name,int number)
	{
		name[number-1]=Name;
	}
	
	public int checkOut(String Name)
	{
		for(int i=0;i<name.length;i++)
		{
			if(name[i].equals(Name))
			{
				name[i]="null";
                return i+1;	
 			}
		}return -1;
	}
	
	public boolean isFull()
	{
		for(int i=0;i<name.length;i++)
		{
			if(name[i]=="null")
			{
				return false;
			}
		}return true;
	}
			

	public static void main(String[] args) 
	{
		Hotel hotel=new Hotel();
		System.out.printf("Welcome XX hotel\n");
	    for(;;)
	    {
	    	System.out.printf("Press 1 for check in\n Press 2 to checkout\n Press 3 to check if hotel has empty room.");
	    	Scanner input=new Scanner(System.in);
	    	int a=input.nextInt();
	    	if(a==1)
	    	{
	    		System.out.printf("Input the name and the number of the room.");
	    		Scanner input1=new Scanner(System.in);
	    		String Name=input1.nextLine();
	    		System.out.printf("Input the number of the room.");
	    		int number=input1.nextInt();
	    		hotel.checkIn(Name, number);
	    	}if(a==2)
	    	{
	    		System.out.printf("Input the name of the customer.");
	    		Scanner input2=new Scanner(System.in);
	    		String Name=input2.nextLine();
	    		int b=hotel.checkOut(Name);
	    		if(b==-1)
	    		{
	    			System.out.println("Sorry we have no this man");
	    		}else System.out.printf("Customer in room No. %d has checked out.",b);
	    	}if(a==3)
	    	{
	    		if(hotel.isFull()==true)
	    		{
	    			System.out.println("Hotel is full");
	    		}else System.out.println("Hotel is not full");
	    	}
	    }

	}

}
