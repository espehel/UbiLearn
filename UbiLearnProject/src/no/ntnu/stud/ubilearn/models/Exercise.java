package no.ntnu.stud.ubilearn.models;

import java.util.ArrayList;
import java.util.Date;

import no.ntnu.stud.ubilearn.R;

public class Exercise extends ListItem{
	private String objectId;
	private String name;
	private String text;
	
	
	
	public Exercise(String objectId, String name, String text) {
		super();
		this.objectId = objectId;
		this.name = name;
		this.text = text;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getObjectId() {
		return objectId;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
		
	}
	@Override
	protected void setIcon() {
		this.icon = R.drawable.ic_navigation_next_item;
		
	}
	@Override
	public String printContent() {
		// TODO Auto-generated method stub
		return null;
	}

}
