package model;

public class Player {
	
	private String name;
	private int points;
//	private List<Guild> conqueredClans = new ArrayList<Guild>();
	
///
	public Player() {
		
	}
	
	public Player(String name) {
		super();
		this.name = name;
		
	}
///
	
	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
//	public List<Guild> getConqueredClans() {
//		return conqueredClans;
//	}
//	
//	public void addConqueredClan(Guild g) {
//		this.conqueredClans.add(g);
//	}
	
	@Override
	public String toString() {
		return getName() + " ";
	}
	
	
}
