package me.erano.com.example1.product;

//Concrete Product
public class HalfNote implements MusicalNote{

	private String duration;

    public HalfNote() {
        this.duration = "Half Note";
    }
	
	@Override
	public HalfNote clone() throws CloneNotSupportedException {
		return (HalfNote) super.clone();
	}

	@Override
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Half Note";
    }
	
}
