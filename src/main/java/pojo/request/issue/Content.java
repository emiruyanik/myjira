package pojo.request.issue;

import java.util.List;

public class Content {
	private String type;
	private List<ContentItem> contentitems;


	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setContent(List<ContentItem> content){
		this.contentitems = content;
	}

	public List<ContentItem> getContent(){
		return contentitems;
	}


}