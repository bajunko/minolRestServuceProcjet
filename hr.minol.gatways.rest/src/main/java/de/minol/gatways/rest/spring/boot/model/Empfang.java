package de.minol.gatways.rest.spring.boot.model;

public enum Empfang {
	
	GUT("G", "Gut"),
	AUSREICHEND("A", "Ausreichend"),
	KEIN_EMPFANG("K", "Kein empfang");
	
	private String sifra;
	private String opis;
	
	private Empfang(final String sifra, final String opis) {
		this.sifra = sifra;
		this.opis = opis;
	}
	
//	public static Empfang fromSifra(final String sifra) {
//		for (Empfang i : Empfang.values()) {
//			if (sifra.equals(i.sifra)) {
//				return i;
//			}
//		}
//		throw new IllegalArgumentException("Nepoznata sifra za IndikatorKlase: '" + sifra + "'.");
//	}

	
	public static Empfang parse(String sifra) {
		for(Empfang item : Empfang.values()){
			if(item.getSifra().equals(sifra)) {
				return item;
			}
		}
		
		throw new IllegalArgumentException("Nepostojeći Empfang '" + sifra + "'");
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
