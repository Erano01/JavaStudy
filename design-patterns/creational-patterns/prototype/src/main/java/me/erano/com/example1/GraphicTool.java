package me.erano.com.example1;

import me.erano.com.example1.product.Graphic;

//Concrete Tool. -> this is client
public class GraphicTool implements Tool{

	private Graphic prototype;
	
	public GraphicTool(Graphic prototype) {
        this.prototype = prototype;
    }
	
	public Graphic createGraphic() throws CloneNotSupportedException {
        return prototype.clone();
    }
}
