package model;

public class Person {
	private String room;
	private String firstName;
	private String lastName;
	private Integer start;
	private Integer finish;
	private String startTxt;
	private String finishTxt;
	
	
	
	public Person(String firstName, String lastName,String room, Integer start, Integer finish){
		this.room=room;
		this.firstName=firstName;
		this.lastName=lastName;
		this.start=start;
		this.finish=finish;
		
		
	}
	public String getRoom(){
		return room;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setRoom( String room){
		this.room=room;
		
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public int getStart(){
		return start;
	}
	public void setStart( Integer start){
		this.start=start;
		
	}
	public int getFinish(){
		return finish;
	}
	public void setFinish( Integer finish){
		this.finish=finish;
		
	}
	public String getFinishTxt() {
		return finish.toString();
	}
	public String getStartTxt() {
		return start.toString();
	}
	
}
