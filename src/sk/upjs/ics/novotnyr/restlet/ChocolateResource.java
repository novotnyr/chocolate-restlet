package sk.upjs.ics.novotnyr.restlet;

import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class ChocolateResource extends ServerResource {
	private Long id;

	@Override
	protected void doInit() throws ResourceException {
		String stringId = (String) getRequestAttributes().get("id");
		this.id = Long.parseLong(stringId);
	}
	
	@Get("json")
	public Chocolate findById() {
		if(id.equals(1L)) {
			return new Chocolate(id, "A Simple Choco", 42);
		}
		throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);		
	}
	
}
