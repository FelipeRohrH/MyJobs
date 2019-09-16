package utils;

public abstract class SpriteModel {
	
	private int x;
	private int y;
	
	private int widthArea;
	private int heightArea;
	
	private boolean visible;
	
	public SpriteModel() {
		
	}
	
	public SpriteModel(int x, int y) {
		this.x = x;
		this.y = y;
		this.visible = true;
	}
	
	public SpriteModel(int x, int y, int widthArea, int heightArea) {
		this.x = x;
		this.y = y;
		this.widthArea = widthArea;
		this.heightArea = heightArea;
		this.visible = true;
	}
	
	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidthArea() {
		return widthArea;
	}

	public int getHeightArea() {
		return heightArea;
	}
	
	/*Abstract*/
	public abstract String getImagePath();
	public abstract int getWidth();
	public abstract int getHeight();
}
