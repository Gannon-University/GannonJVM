package com.gannon.asm.classgenerator;

public class LargestNumSum {

	public int largeNumSum(int a, int b, int c, int p, int q, int r, int ka, int kp){
		
		//sub prg 1;
		if(a>b)
		{
			if(a>c)
				ka=a;
			else
			{
				if(c>b)
					ka=c;
				else
					ka=b;
			}
		}
		else
		{
			if(a>b)
				return 1;
			else
			{
				if(b>c)
					ka=b;
				else
				{
					if(a>c)
						ka=a;
					else
						ka=c;
				}
			}
		}	
		
		//Sub prg 2
		if(p>q)
		{
			if(p>r)
				kp=p;
			else
			{
				if(r>q)
					kp=r;
				else
					kp=q;
			}
		}
		else
		{
			if(p>q)
				return 2;
			else
			{
				if(q>r)
					kp=q;
				else
				{
					if(p>r)
						kp=p;
					else
						kp=r;
				}
			}
		}	
		return ka+kp;
	}   	
}
