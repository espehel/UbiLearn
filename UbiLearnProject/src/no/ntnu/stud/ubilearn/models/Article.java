package no.ntnu.stud.ubilearn.models;

import java.util.Date;

import no.ntnu.stud.ubilearn.R;
import no.ntnu.stud.ubilearn.fragments.handbook.ArticleFragment;

/**
 * Simple model containing data for Articles used in {@link ArticleFragment}.
 */
public class Article extends ListItem{
	
	private String objectId;
	private String title;
	private String content;
	private Date createdAt;
	

	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}

//	public Article(long id, String objectId, String title, String content, Date createdAt, long parentId) {
//		super();
//		this.id = id;
//		this.objectId = objectId;
//		this.title = title;
//		this.content = content;
//		this.createdAt = createdAt;
//		this.parentId = parentId;
//	}

	public Article(String objectId, String title, String content, Date createdAt, String parentId) {
		super();
		this.objectId = objectId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.parentId = parentId;
	}

	@Override
	protected void setIcon() {
		this.icon = R.drawable.ic_handbook_black;
	}
	
	public String getObjectId() {
		return objectId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public String getParentId(){
		return parentId;
	}

	@Override
	public String getName() {
		return title;
	}

	@Override
	public void setName(String name) {
		title = name;		
	}

	public String printContent() {
		return "Article [objectId=" + objectId + ", title=" + title
				+ ", content=" + content + ", createdAt=" + createdAt
				+ ", parentId=" + parentId + "]";
	}
	
	@Override
	public String toString(){
		return title;
	}

}
