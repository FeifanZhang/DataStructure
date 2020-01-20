package 第三章;

import java.util.Scanner;

public class Bogart extends PolyhedralDie//3.13
{
	int p1;
	int p1Die;
	int p2;
	int p2Die;
	int pot;
	int transfer;
    public Bogart()
    {
    	 p1=0;
    	 p1Die=0;
    	 p2=0;
    	 p2Die=0;
    	 pot=0;
         transfer=1;//从p1开始
    }
	
    public int check()//检查是否满足获胜条件
    {
    	if(p1>=30||p1Die>=5)
    	{
    		return 1;//p1可以赢
    	}if(p2>=30||p2Die>=5)
    	{
    		return 2;//p2可以赢
    	}else return 3;//没人可以赢
    }
    
    public void play()
    {
    	System.out.printf("It is the turn for player %d",transfer);
    	int result=0;
    	for(int i=1;;i++)
    	{	
    		pot+=i;
    		this.roll(6);
    		if(transfer==1) p1Die++;
    		else p2Die++;
    		System.out.println("your result is "+this);
    		
    		if(this.getTopFace()==1)
    		{
    			System.out.print("Sorry you have aced out and your turn ends.\n");
    			transfer=3-transfer; //转换到另一个player
    			return;
    		}else
    		{
    			System.out.printf("Press 1 to continue rolling Press 2 to collect the %d chips in the pot.\n",pot);
    			Scanner input=new Scanner(System.in);
    			result=input.nextInt();
    		}if(result==2)
    		{
    			if(transfer==1)p1+=pot;
    			else p2+=pot;
    			pot=0;
    			transfer=3-transfer; //转换到另一个player
    			return;
    		}
    		
    	}
    }
	public static void main(String[] args) 
	{
		
		Bogart bogart=new Bogart();
		
		for(;;)
		{

			if(bogart.check()!=3)
			{
				System.out.printf("Player %d win!",bogart.check());
				return;
			}
			if(bogart.check()==3)
			{
				bogart.p2Die=0;
				bogart.p1Die=0;
				bogart.play();
			}
			
		}

	}

}
