package de.minol.gatways.rest.spring.boot.model;

public enum Geschloss {
	UG("UG", "UG"),
	EG("EG", "EG"),
	ERSTE_OG("OG", "ERSTE OG"),
	DG("DG", "DG");
	
	private String sifra;
	private String opis;
	
	private Geschloss(final String sifra, final String opis) {
		this.sifra = sifra;
		this.opis = opis;
	}
	
//	public static Geschloss fromSifra(final String sifra) {
//		for (Geschloss i : Geschloss.values()) {
//			if (sifra.equals(i.sifra)) {
//				return i;
//			}
//		}
//		throw new IllegalArgumentException("Nepoznata sifra za Geschloss: '" + sifra + "'.");
//	}

	
	public static Geschloss parse(String sifra) {
		for(Geschloss item : Geschloss.values()){
			if(item.getSifra().equals(sifra)) {
				return item;
			}
		}
		
		throw new IllegalArgumentException("Nepostojeći Geschloss '" + sifra + "'");
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

