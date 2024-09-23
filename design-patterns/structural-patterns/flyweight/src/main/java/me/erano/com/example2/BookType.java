package me.erano.com.example2;
 
//BookType is our Flyweight class.
//Flyweights are immutable. intrinsic state is invariant context-independent shareable and never altered at runtime.
public class BookType {

	//instrinsic state of the Book objects.
    private final String type;
    private final String distributor;
    private final String otherData;

	public BookType(String type, String distributor, String otherData) {
		super();
		this.type = type;
		this.distributor = distributor;
		this.otherData = otherData;
	}
	
	public String getType() {
		return type;
	}
	public String getDistributor() {
		return distributor;
	}
	public String getOtherData() {
		return otherData;
	}

	@Override
	public String toString() {
		return "BookType [type=" + type + ", distributor=" + distributor + ", otherData=" + otherData + "]";
	}

	
    
}
