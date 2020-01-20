package 第十二章;
import 第五章.ArrayList;
import 第八章.SortableLinkedList;

public class Fuyan {
	
	public static void bucketSort(double[]data){
		
		
		double max=data[0];
		double min=data[0];
		int n=data.length;
		
		List<SortableLinkedList<Double>> bucketsPositive=new ArrayList<SortableLinkedList<Double>>();
		List<SortableLinkedList<Double>> bucketsNegative=new ArrayList<SortableLinkedList<Double>>();
		
		for(int i=0;i<data.length;i++){
			if(data[i]>max)max=data[i];
			if(data[i]<min)min=data[i];
		}
					
		for(int i=0;i<n;i++){
			if(data[i]>=0)bucketPositive.add(new SortableLinkedList<Double>());
			if(data[i]>0)bucketNegative.add(new SortableLinkedList<Double>());
		}
		
		for(int i=0;i<n;i++){
			if(data[i]>=0)bucketPositive.get((int)(data[i]%max*bucketPositive.size())).add(data[i]);
			if(data[i]<0)bucketNegetive.get((int)(data[i]%min*bucketNegetive.size())).add(data[i]);
		}
		
		int i=0;
		
		for(SortableLinkedList<Double> bucket:bucketNegative){
			bucket.insertionSort();
			for(Double d:bucket){ 
            	  data[i]=d;
            	  i++;   			 
			}
		}
		
		
		for(SortableLinkedList<Double> bucket:bucketPositive){
			bucket.insertionSort();
			for(Double d:bucket){ 
            	  data[i]=d;
            	  i++;   			 
			}
		}
		
		

	}
}
