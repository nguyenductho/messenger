package vn.mobifone.thonguyen.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private String message;
	private String author;
	private Date created;
	private long id;
	
	
	public Message() {
		
	}

	public Message(String message, String author, Date created, long id) {
		super();
		this.message = message;
		this.author = author;
		this.created = created;
		this.id = id;
	}
	
	public Message( long id, String message, String author) {
		this.message = message;
		this.author = author;
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

}
