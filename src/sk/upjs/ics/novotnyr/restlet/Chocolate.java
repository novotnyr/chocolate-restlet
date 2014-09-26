package sk.upjs.ics.novotnyr.restlet;

public class Chocolate {
	private Long id;
	
	private String title;
	
	private int percentage;
	
	public Chocolate() {
		// empty constructor
	}
	
	public Chocolate(Long id, String title, int percentage) {
		this.id = id;
		this.title = title;
		this.percentage = percentage;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public int getPercentage() {
		return percentage;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
