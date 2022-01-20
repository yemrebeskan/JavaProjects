import java.util.ArrayList;
//sorts the list taken from the file by application id's
public class listsorting{
	public static void sortArray(ArrayList<String> arraylist,int numberOfUsed){
		int index,indexOfNextSmallest;
		for(index = 0; index < numberOfUsed - 1;index++) {
			indexOfNextSmallest = indexOfSmallest(index, arraylist, numberOfUsed);	
			interchange(index,indexOfNextSmallest,arraylist);
		}
		
		
	}
	private static int indexOfSmallest(int StartIndex,ArrayList<String> a,int numberUsed) {
		String id = a.get(StartIndex).split(",")[1];
		int indexOfMin = StartIndex;
		int index;
		
		for(index = StartIndex + 1;index < numberUsed; index++){
			if(a.get(index).split(",")[1].compareTo(id) < 0) {
				id = a.get(index).split(",")[1];
				indexOfMin = index;
			}
			
		}
		
		
		return indexOfMin;
	}
	private static void interchange(int i,int j,ArrayList<String> a) {
		String temp;
		temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}
	
		
	
}
