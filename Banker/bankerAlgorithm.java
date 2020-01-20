
public class bankerAlgorithm 
{
	 //可利用资源向量 有m个available[j]=k表示系统中Rj资源有k个
     private int[]available;
     
     //最大需求矩阵max n*m max[i][j]=k:进程i需要Rj类资源最多为K
     private int[][]max;
     
     //分配矩阵 n*m allocation[i][j]=k:进程i已经拥有Rj类资源数为K
     private int[][]allocation;
     
     //分配矩阵 n*m allocation[i][j]=k:进程i还需要k个Rj类资源
     private int[][]need;
     
     public bankerAlgorithm()
     {
    	 this.available = new int[]{3,3,2};//可得到的资源

    	 this.max= new int[][]{{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};//每个进程最大资源数

    	 this.allocation = new int[][]{{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};//每个进程目前拥有的资源数

    	 this.need = new int[][]{{7,4,3},{1,2,2},{6,0,0},{0,1,1},{4,3,1}};//每个进程需要的资源数
     }
     
     protected void showData()//展示数据输出每个进程的相关数据

     {

        System.out.println("进程号      Max   Allocation  Need   ");

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
    			System.out.println("请求的资源数超过了所需要的最大值，分配错误");
    			return false;
    		}
    	}
    	
    	for(int i=0;i<3;i++)
    	{
    		if(request[i]>this.available[i])
    		{
    			System.out.println("没有足够资源，请等待");
    			return false;
    		}
    	}
    	
    	for(int i = 0;i<3;i++)//试分配数据给请求的线程
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
    		System.out.println("系统有锁死的风险");
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
    				System.out.println("分配成功的是"+i);

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
