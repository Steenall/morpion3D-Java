package gobblets.data;

public enum Couleur implements java.io.Serializable {
	ROUGE(255,0,0,"\033[31m"),
	VERT(0,255,0,"\033[32m"),
	BLEU(0,0,255,"\033[34m"),
	JAUNE(255,255,0,"\033[93m"),
	WHITE(255,255,255,"\033[39m"),
	MAGENTA(255,0,255,"\033[95m"),
	CYAN(0,255,255,"\033[96m");
	private final int r;
	private final int g;
	private final int b;
	private String code="";
	
	private Couleur(int r, int g, int b,String code) {
		// TODO Auto-generated constructor stub
		this.r=r;
		this.g=g;
		this.b=b;
		this.code=code;
	}
	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}
	public String getCode() {
		return code;
	}
	@Override
	public String toString() {
		return code+"Couleur : "+"("+r+", "+g+", "+b+")"+Couleur.WHITE.getCode();
	}
}
