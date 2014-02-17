package databeans;


public class TweetBean {
	private String text;
	private long favourites_count;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getFavourites_count() {
		return favourites_count;
	}
	public void setFavourites_count(long favourites_count) {
		this.favourites_count = favourites_count;
	}
	
	
}
