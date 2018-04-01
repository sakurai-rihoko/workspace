package com.yzq.refType;

import java.util.Date;
import java.util.List;
import java.lang.*;
import java.text.SimpleDateFormat;
public class NewsItem implements Comparable<NewsItem>{
	private String title;
	private int hits;
	private Date pubTime;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	public NewsItem(String title, int hits, Date pubTime) {
		this();
		this.title = title;
		this.hits = hits;
		this.pubTime = pubTime;
	}
	public NewsItem() {
		super();
	}
	@Override
	//时间降序+点击量升序+标题
	public int compareTo(NewsItem o) {
		// TODO Auto-generated method stub
		int result = 0;
		result = -this.pubTime.compareTo(o.pubTime);
		if(result == 0) {
			result = (-this.hits - o.hits)>0?1:-1;
			if(result == 0) {
				return this.title.compareTo(o.title);
			}else {
				return result;
			}
		}else {
			return result;
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("标题").append(this.title);
		sb.append("点击量").append(this.hits);
		sb.append("发布时间").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.pubTime)).append("\n");
		return sb.toString();
	}
	
}
