
public class bankerAlgorithm 
{
	 //��������Դ���� ��m��available[j]=k��ʾϵͳ��Rj��Դ��k��
     private int[]available;
     
     //����������max n*m max[i][j]=k:����i��ҪRj����Դ���ΪK
     private int[][]max;
     
     //������� n*m allocation[i][j]=k:����i�Ѿ�ӵ��Rj����Դ��ΪK
     private int[][]allocation;
     
     //������� n*m allocation[i][j]=k:����i����Ҫk��Rj����Դ
     private int[][]need;
     
     public bankerAlgorithm()
     {
    	 this.available = new int[]{3,3,2};//�ɵõ�����Դ

    	 this.max= new int[][]{{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};//ÿ�����������Դ��

    	 this.allocation = new int[][]{{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};//ÿ������Ŀǰӵ�е���Դ��

    	 this.need = new int[][]{{7,4,3},{1,2,2},{6,0,0},{0,1,1},{4,3,1}};//ÿ��������Ҫ����Դ��
     }
     
     protected void showData()//չʾ�������ÿ�����̵��������

     {

        System.out.println("���̺�      Max   Allocation  Need   ");

        System.out.println("     A  B  C  A  B  C  A  B  C");

        for(int i = 0;i<5;i++)

        {

             System.out.print(i+"    ");

             for(int m = 0;m<3;m++) System.out.print(max[i][m]+"  ");

             for(int m = 0;m<3;m++) System.out.print(allocation[i][m]+"  ");

             for(int m = 0;m<3;m++) System.out.print(need[i][m]+"  ");

             System.out.println();

       }

    }
     
    private boolean change(int[]request,int Request)
    {
    	for(int i=0;i<3;i++)
    	{
    		if(request[i]>need[Request][i])
    		{
    			System.out.println("�������Դ������������Ҫ�����ֵ���������");
    			return false;
    		}
    	}
    	
    	for(int i=0;i<3;i++)
    	{
    		if(request[i]>this.available[i])
    		{
    			System.out.println("û���㹻��Դ����ȴ�");
    			return false;
    		}
    	}
    	
    	for(int i = 0;i<3;i++)//�Է������ݸ�������߳�
    	{
    	   available[i] = available[i]-request[i];

    	   allocation[Request][i] = allocation[Request][i] + request[i];

    	   need[Request][i] = need[Request][i] - request[i];
    	}

    	if(safetyCheck(this.available)==true)return true;
    	else{
    		for(int i = 0;i<3;i++)
    		{
    		   available[i] = available[i]+request[i];

    		   allocation[Request][i] = allocation[Request][i] - request[i];

    		   need[Request][i] = need[Request][i] + request[i];
    		}
    		System.out.println("ϵͳ�������ķ���");
    		return false;
    	}
    	
    }
    
    private boolean safetyCheck(int[]available)
    {
    	boolean[] Finish=new boolean[max.length];
    	int[]work=new int[this.available.length];
    	for(int i=0;i<work.length;i++)
    	{
    		work[i]=this.available[i];
    	}
    	
    		for(int i=0;i<Finish.length;i++)
    		{
    			if(Finish[i]==false&&need[i][0]<=work[0]&&need[i][1]<=work[1]&&need[i][2]<=work[2])
    			{
    				System.out.println("����ɹ�����"+i);

    				for(int m = 0;m<3;m++)

    				work[m] =work[m] + allocation[i][m];

    				Finish[i] = true;

    				i=0;
    			}else i++;
    		}
    		
    		return!(checkFalse(Finish));
    	
    }
    
  
    private boolean checkFalse(boolean[] Finish)
    {
    	for(int i=0;i<Finish.length;i++)
    	{
    		if(Finish[i]==false)return true; 
    	}return false;
    }
    
    public void start(int[]request,int Request)
    {
    	this.showData();
    	if(this.change(request, Request)==true)this.showData();
    }
    
    
}
