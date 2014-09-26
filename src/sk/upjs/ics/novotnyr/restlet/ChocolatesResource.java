package sk.upjs.ics.novotnyr.restlet;

import java.util.ArrayList;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ChocolatesResource extends ServerResource{
	@Get("json")
	public List<Chocolate> listChocolates() {
		List<Chocolate> chocolates = new ArrayList<Chocolate>(2);
		chocolates.add(new Chocolate(1L, "Lindt Excellence 70%", 70));
		chocolates.add(new Chocolate(2L, "Milka Alpenmilch", 40));
		chocolates.add(new Chocolate(3L, "Christmas Angel Figure", 15));
		
		return chocolates;
	}
	
	@Post
	public void addChocolate(Chocolate chocolate) {
		System.out.printf("Adding %s with %d%% of cocoa butter/mass\n", chocolate.getTitle(), chocolate.getPercentage());
	}	
}
