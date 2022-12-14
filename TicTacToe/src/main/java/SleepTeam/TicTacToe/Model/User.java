package SleepTeam.TicTacToe.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

//@Table(name = "users")
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String username;
	
	private String password;
	
	private int wins;
	
	private int losses;

	public User() {
		
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.wins = 0;
		this.losses = 0;
	}
	
	public User(String username, String password, int wins, int losses) {
		this.username = username;
		this.password = password;
		this.wins = wins;
		this.losses = losses;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	@JsonProperty(value = "password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	
}
