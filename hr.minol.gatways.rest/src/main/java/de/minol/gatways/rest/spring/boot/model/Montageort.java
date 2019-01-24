package de.minol.gatways.rest.spring.boot.model;

public enum Montageort {
	
	INDOOR("I", "Indoor"),
	OUTDOOR("O", "Outdoor"),
	HYBRID("H", "Hybrid");
	
	private String sifra;
	private String opis;
	
	private Montageort(final String sifra, final String opis) {
		this.sifra = sifra;
		this.opis = opis;
	}
	
//	public static Montageort fromSifra(final String sifra) {
//		for (Montageort i : Montageort.values()) {
//			if (sifra.equals(i.sifra)) {
//				return i;
//			}
//		}
//		throw new IllegalArgumentException("Nepoznata sifra za Lage: '" + sifra + "'.");
//	}
	public static Montageort parse(String sifra) {
		for(Montageort item : Montageort.values()){
			if(item.getSifra().equals(sifra)) {
				return item;
			}
		}
		
		throw new IllegalArgumentException("Nepostojeći Montageort '" + sifra + "'");
	}	

	/**
	 * @return the sifra
	 */
	public String getSifra() {
		return sifra;
	}

	/**
	 * @return the opis
	 */
	public String getOpis() {
		return opis;
	}


}
