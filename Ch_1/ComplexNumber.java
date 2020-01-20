package µÚÒ»ÕÂ;

public class ComplexNumber
{
	double real;
	double imaginary;
	public ComplexNumber(double realPart,double imaginaryPart)
	{
		if(check(realPart,imaginaryPart)==true)
		{
			real=realPart;
		    imaginary=imaginaryPart;
		}else
		{
		real=0;
		imaginary=0;
		}
	}
	
	private boolean check(double realPart,double imaginaryPart)
	{
		if(realPart>0&&imaginaryPart>0)
		{
			return true;
		}
		return false;
	}
	
	public void add(ComplexNumber number)
	{
		ComplexNumber x=new ComplexNumber(number.getRealPart(),number.getImaginaryPart());
	}
	
	public double getImaginaryPart()
	{
		return imaginary;
	}
	
	public double getRealPart()
	{
		return real;
	}
	
	public double getAngle()
	{
		return Math.toDegrees(Math.atan(getRealPart()));
	}
	
	public double getMagnitude()
	{
		return Math.sqrt(real*real+imaginary*imaginary);
	}
			
	public static void main(String[] args)
	{
		ComplexNumber x=new ComplexNumber(3,4);

		System.out.println(x.getMagnitude());
		System.out.println(x.getAngle());
	}

}
