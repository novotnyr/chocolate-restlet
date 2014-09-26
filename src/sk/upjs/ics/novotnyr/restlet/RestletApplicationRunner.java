package sk.upjs.ics.novotnyr.restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class RestletApplicationRunner {
	public static void main(String[] args) throws Exception {
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8182);
		component.getDefaultHost().attach("/chocolate/{id}", ChocolateResource.class);
		component.getDefaultHost().attach("/chocolate", ChocolatesResource.class);
		
		component.start();
		
		
	}
}
