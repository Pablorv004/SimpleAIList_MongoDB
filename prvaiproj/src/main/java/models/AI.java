package models;

import java.util.Objects;

public class AI {
	private int id;
	private String name, type;
	private int year;
	private String imgPath;
	
	public AI() {
		
	}
	public AI(int id, String name, String type, int year, String imgPath) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.year = year;
		this.imgPath = imgPath;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "AI [id= " + id + "name=" + name + ", type=" + type + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AI other = (AI) obj;
		return id == other.id;
	}
	
	
}
