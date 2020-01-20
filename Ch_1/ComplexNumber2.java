package ╣зр╩уб;

public class ComplexNumber2 extends ComplexNumber
{
    
	public ComplexNumber2(double angle, double magnitude) 
	{
		super(Math.sin(Math.toRadians(angle))*magnitude,Math.sqrt(magnitude*magnitude-Math.sin(Math.toRadians(angle))*magnitude*Math.sin(Math.toRadians(angle))*magnitude) );
	}

	public static void main(String[] args) 
	{
		ComplexNumber2 a=new ComplexNumber2(30,2);
        System.out.print(a.getImaginaryPart());
	}

}
