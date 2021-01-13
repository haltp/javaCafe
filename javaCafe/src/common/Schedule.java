package common;

public class Schedule {
	public String title;
	public String startDay;
	public String endDay;
	public String url;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Schedule [title=" + title + ", startDay=" + startDay + ", endDay=" + endDay + ", url=" + url + "]";
	}
	
	
}
