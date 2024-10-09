package me.erano.com.example.product;

//Concrete Product
public class WholeNote implements MusicalNote{

	private String duration;

    public WholeNote() {
        this.duration = "Whole Note";
    }
	
	@Override
	public WholeNote clone() throws CloneNotSupportedException {
		return (WholeNote) super.clone();
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
        return "Whole Note";
    }
}
