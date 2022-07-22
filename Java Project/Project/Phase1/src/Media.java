

public abstract class Media implements Comparable<Media> {

	protected String title;
	protected int Copies;


	protected Media(String title, int copiesAvailable) {

		this.title = title;
		this.Copies = copiesAvailable;

	}
	public String getTitle() {
		return title;
	}


	public int getCopies() {
		return Copies;
	}

	public void numberOfCopiesAvailable(boolean add) {

		if (add) {
			this.Copies++;
		} else {
			this.Copies--;
		}

	}
	@Override
	public int compareTo(Media o) {

		Media temp = (Media) o;

		return this.getTitle().compareTo(temp.getTitle());
	}



}

