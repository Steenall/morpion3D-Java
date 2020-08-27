package gobblets.data;

public enum Taille implements java.io.Serializable{ 
	PETITE('●') {
		@Override
		public boolean recouvre(Taille uneTaille) {
			// TODO Auto-generated method stub
			return false;
		}
	},
	MOYENNE('▲') {
		@Override
		public boolean recouvre(Taille uneTaille) {
			// TODO Auto-generated method stub
			if(uneTaille==null)return false;
			return uneTaille.equals(Taille.PETITE);
		}
	},
	GRANDE('■') {
		@Override
		public boolean recouvre(Taille uneTaille) {
			// TODO Auto-generated method stub
			return !(uneTaille.equals(Taille.GRANDE));
		}
	};
	private final char symbole;
	public char getSymbole() {
		return symbole;
	}
	private Taille(char symbole) {
		// TODO Auto-generated constructor stub
		this.symbole=symbole;
	}
	public boolean recouvre(Piece unePiece){
		return recouvre(unePiece.getTaillePiece());
	}
	public abstract boolean recouvre(Taille uneTaille);
}
