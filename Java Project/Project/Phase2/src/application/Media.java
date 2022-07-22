package application;

public abstract class Media implements Comparable<Media> {

	protected String Code;
	protected String title;
	protected int Copies;

	public Media() {
		Code = "";
		this.title = "";
		Copies = 0;
	}

	protected Media(String code, String title, int copies) {
		Code = code;
		this.title = title;
		Copies = copies;
	}

	public String getCode() {
		return Code;
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
		int x = this.getCode().compareToIgnoreCase(o.getCode());
		if (x == 0) {
			return 0;
		} else if (x > 0) {
			return 1;
		} else
			return -1;

	}

}
