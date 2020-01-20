package ตฺศýีย;

public class PolyhedralDie extends Die
{

	public void roll(int side) 
	{
		 this.setTopFace((int)(Math.random()*side)+1);
	}
	
	public static void main(String[] args)
	{
		 PolyhedralDie d = new PolyhedralDie();
		 System.out.println("Before rolling: " + d);
		 d.roll(2);
		 System.out.println("After rolling: " + d);

	}

}
