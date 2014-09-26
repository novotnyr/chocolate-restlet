package sk.upjs.ics.novotnyr.restlet.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import sk.upjs.ics.novotnyr.restlet.Chocolate;

public class ChocolateClientTest {
	@Test
	public void testGetChocolate() throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://localhost:8182/chocolate");
		clientResource.get().write(System.out);
	}

	public static class ChocolateList extends ArrayList<Chocolate> { /** nothing here **/ }

	@Test
	public void testGetTypedChocolateList() throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://localhost:8182/chocolate");
		List<Chocolate> chocolates = clientResource.get(ChocolateList.class);
		System.out.println(chocolates);
	}

	
	@Test
	public void testGetChocolateList() throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://localhost:8182/chocolate");
		List<Chocolate> chocolates = clientResource.get(List.class);
		System.out.println(chocolates);
	}

	@Test
	public void testGetSingleChocolate() throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://localhost:8182/chocolate/1");
		Chocolate chocolate = clientResource.get(Chocolate.class);
		System.out.println(chocolate);
	}

	@Test
	public void testGetSingleChocolateThatDoesNotExist() throws ResourceException, IOException {
		Chocolate chocolate;
		try {
			ClientResource clientResource = new ClientResource("http://localhost:8182/chocolate/25");
			chocolate = clientResource.get(Chocolate.class);
			// expect an exception!
			fail("No ResourceException was thrown, but was expected");
		} catch (ResourceException e) {
			assertEquals(Status.CLIENT_ERROR_NOT_FOUND, e.getStatus());
		}
	}
	
	@Test
	public void testPostChocolate() throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://localhost:8182/chocolate");
		clientResource.post(new Chocolate(5L, "Deva Bar", 10));
	}
	
	@Test
	public void testPostJson() throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://localhost:8182/chocolate");
		Representation representation = new StringRepresentation("{\"title\" : \"Lindt Excellence 70%\", \"percentage\": 70 }", MediaType.APPLICATION_JSON);
		clientResource.post(representation);
	}		
}


