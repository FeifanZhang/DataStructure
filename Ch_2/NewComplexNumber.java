package 第二章;

import 第一章.ComplexNumber;
//2.9
public class NewComplexNumber extends ComplexNumber
{

	public NewComplexNumber(double realPart, double imaginaryPart) 
	{
		super(realPart, imaginaryPart);
	}
	
	
	public boolean equals(ComplexNumber number)
	{
		if(this.getClass()!=number.getClass())
		{
			return false;
		}
		if(number==null)
		{
			return false;
		}
		if(this.getRealPart()==number.getRealPart()&&this.getImaginaryPart()==number.getImaginaryPart())
		{
			return true;
		}
		else return false;
	}

}
