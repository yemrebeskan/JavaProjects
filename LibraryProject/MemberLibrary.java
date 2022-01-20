
public class MemberLibrary {
	private  Member[] memberlist;
	private  int length;
	
	MemberLibrary(Member[] new_memberlist,int size_Of_List){	//Constructor
		memberlist = new_memberlist;
		length = size_Of_List;
		
	}
	
	public  Member[] getMemberList() {	//Copy of the array is created and returned to prevent privacy leak.
		Member[] copiedList = new Member[length];
		for(int i = 0;i < length;i++) {
			copiedList[i] = memberlist[i];
		}
		return copiedList;
	}
	
	public  int getLength() {
		int copied_size = length;
		return copied_size;
	}
	
	
}
