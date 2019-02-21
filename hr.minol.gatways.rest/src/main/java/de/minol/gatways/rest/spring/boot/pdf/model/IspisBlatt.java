package de.minol.gatways.rest.spring.boot.pdf.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;

import de.minol.gatways.rest.spring.boot.model.BlattLtdnr;
import de.minol.gatways.rest.spring.boot.model.FormBlatt;

public class IspisBlatt {
	
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	DateFormat dateFormatYear = new SimpleDateFormat("yyyy");
	
	private String naslov1;
	private String ausenbereich;
	private String innenbereich;
	private String weitereMessstellen;
	private String montageOrt;
	
	private long id;
	private String macAdresseBlatt1;
	private String adresseDesObjektes;
	private String lgNr;
	private String ansprechperson;
	private String telNrAnsprechenperson;
	private String mobilfunkverbindungVorhanden;
	private String begehungsdatum;
	private String bausubstanz;
	private String auftragsnummer;
	private String aussenbereichVorderseite;
	private String aussenbereichHinterseite;
	private String aussenbereichLinkeseite;
	private String aussenbereichRechteseite;
	private String innenbereichEingangLinksOben;
	private String innenbereichEingangMittigOben;
	private String innenbereichEingangRechtsOben;
	private String innenbereichEingangLinksUnten;
	private String innenbereichEingangMittigUnten;
	private String innenbereichEingangRechtsUnten;
	private String weitereMessstellenHeizraum;
	private String weitereMessstellenWaschkuche;
	private String weitereMessstellenAnderes1;
	private String weitereMessstellen1;
	private String weitereMessstellenAnderes2;
	private String weitereMessstellen2;
	private String weitereMessstellenAnderes3;
	private String weitereMessstellen3;
	private String weitereMessstellenAnderes4;
	private String weitereMessstellen4;
	private String montageortDesGatewaysAdresse;
	private String montageortDesGatewaysHausnummer;
	private String montageortDesGatewaysRaumbezeichung;
	private String steckdoseBereitsVorhanden;
	private String bohrschabloneAngebract;
	private boolean username;
    private String auftragsNumer;
	private String lgNrGateway;
	private String plz;
	private String ort;
	private String strasse;
	private String montageDatum;
	private String servicePartnerNr;
	private String unterschiftServicePartner;
	private String bemerkungenZurMontage;
	private String beiHybridInstallationLfdNrDesGateways;
	private String beiHybridInstallationLMontagepositionDerAntenne;
	private String beiHybridInstallationSonstigeBemerkung;
	private String startdatum;
	private List<BlattLtdnr> blattLtdnr;
	private List<IspisBlattLtdnr> ispisLtdnr;
	
	
	public IspisBlatt(FormBlatt blatt) {
		
		this.macAdresseBlatt1 = "MAC Adresse Blatt Eins: " + formatiranjePropertija( blatt.getMacAdresseBlatt1());
		this.adresseDesObjektes = "Adresse Des Objektes: " + formatiranjePropertija( blatt.getAdresseDesObjektes());
		this.lgNr = "LG-Nr.: " + formatiranjePropertija(blatt.getLgNr());
		this.ansprechperson = "Ansprechperson: " + formatiranjePropertija( blatt.getAnsprechperson());
		this.telNrAnsprechenperson = "Tel-Nr. Ansprechenperson: " + formatiranjePropertija( blatt.getTelNrAnsprechenperson());
		this.mobilfunkverbindungVorhanden = "Mobilfunkverbindung vorhanden: " + formatiranjeJaOderNein( blatt.isMobilfunkverbindungVorhanden());
		this.begehungsdatum = "Begehungsdatum: " + formatiranjeDatuma( blatt.getBegehungsdatum());
		this.bausubstanz = "Bausubstanz: " + formatiranjePropertija( blatt.getBausubstanz() != null ? blatt.getBausubstanz().getOpis() : "");
		this.auftragsnummer = "Auftragsnummer: " + formatiranjePropertija( blatt.getAuftragsnummer());
		this.ausenbereich = "Messpunkte Außenbereich";
		this.innenbereich = "Messpunkte Innenbereich";
		this.aussenbereichVorderseite = "Vorderseite: " + formatiranjePropertija( blatt.getAussenbereichVorderseite() != null ? blatt.getAussenbereichVorderseite().getOpis() : "");
		this.aussenbereichHinterseite = "Hinterseite: " + formatiranjePropertija( blatt.getAussenbereichHinterseite() != null ? blatt.getAussenbereichHinterseite().getOpis() : "");
		this.aussenbereichLinkeseite = "Linke Seite: " + formatiranjePropertija( blatt.getAussenbereichLinkeseite() != null ? blatt.getAussenbereichLinkeseite().getOpis() : "");
		this.aussenbereichRechteseite = "Rechte Seite: " + formatiranjePropertija( blatt.getAussenbereichRechteseite() != null ? blatt.getAussenbereichRechteseite().getOpis() : "");
		this.innenbereichEingangLinksOben = "Eingang Links Oben: " + formatiranjePropertija( blatt.getInnenbereichEingangLinksOben() != null ? blatt.getInnenbereichEingangLinksOben().getOpis() : "");
		this.innenbereichEingangMittigOben = "Eingang Mittig Oben: " + formatiranjePropertija( blatt.getInnenbereichEingangMittigOben() != null ? blatt.getInnenbereichEingangMittigOben().getOpis() : "");
		this.innenbereichEingangRechtsOben = "Eingang Rechts Oben: " + formatiranjePropertija( blatt.getInnenbereichEingangRechtsOben() != null ? blatt.getInnenbereichEingangRechtsOben().getOpis() : "");
		this.innenbereichEingangLinksUnten = "Eingang Links Unten: " + formatiranjePropertija( blatt.getInnenbereichEingangLinksUnten() != null ? blatt.getInnenbereichEingangLinksUnten().getOpis() : "");
		this.innenbereichEingangMittigUnten = "Eingang Mittig Unten: " + formatiranjePropertija( blatt.getInnenbereichEingangMittigUnten() != null ? blatt.getInnenbereichEingangMittigUnten().getOpis() : "");
		this.innenbereichEingangRechtsUnten = "Eingang Rechts Unten: " + formatiranjePropertija( blatt.getInnenbereichEingangRechtsUnten() != null ? blatt.getInnenbereichEingangRechtsUnten().getOpis() : "");
		this.weitereMessstellen = "Weitere Messstellen (Räume mit abzulesenden Messgeräten)";
		this.weitereMessstellenHeizraum = "Heizraum: " + formatiranjePropertija( blatt.getWeitereMessstellenHeizraum() != null ? blatt.getWeitereMessstellenHeizraum().getOpis() : "");
		this.weitereMessstellenWaschkuche = "Waschkuche: " + formatiranjePropertija( blatt.getWeitereMessstellenWaschkuche() != null ? blatt.getWeitereMessstellenWaschkuche().getOpis() : "");
		this.weitereMessstellenAnderes1 = formatiranjePropertija( blatt.getWeitereMessstellenAnderes1() != null ? blatt.getWeitereMessstellenAnderes1().getOpis() : "");
		this.weitereMessstellen1 = formatiranjePropertija(blatt.getWeitereMessstellen1()) + ": " + getWeitereMessstellenAnderes1();
		this.weitereMessstellenAnderes2 = formatiranjePropertija( blatt.getWeitereMessstellenAnderes2() != null ? blatt.getWeitereMessstellenAnderes2().getOpis() : "");
		this.weitereMessstellen2 = formatiranjePropertija(blatt.getWeitereMessstellen1()) + ": " + getWeitereMessstellenAnderes1();
		this.weitereMessstellenAnderes3 = formatiranjePropertija( blatt.getWeitereMessstellenAnderes3() != null ? blatt.getWeitereMessstellenAnderes3().getOpis() : "");
		this.weitereMessstellen3 = formatiranjePropertija(blatt.getWeitereMessstellen3()) + ": " + getWeitereMessstellenAnderes3();
		this.weitereMessstellenAnderes4 = formatiranjePropertija( blatt.getWeitereMessstellenAnderes4() != null ? blatt.getWeitereMessstellenAnderes4().getOpis() : "");
		this.weitereMessstellen4 = formatiranjePropertija(blatt.getWeitereMessstellen4()) + ": " + getWeitereMessstellenAnderes4();
		
		
		this.montageOrt = "Montageort des Gateways:";
		this.montageortDesGatewaysAdresse = "Adresse: " + formatiranjePropertija( blatt.getMontageortDesGatewaysAdresse());
		this.montageortDesGatewaysHausnummer = "Hausnummer: " + formatiranjePropertija( blatt.getMontageortDesGatewaysHausnummer());
		this.montageortDesGatewaysRaumbezeichung = "Raumbezeichung: " + formatiranjePropertija( blatt.getMontageortDesGatewaysRaumbezeichung());
//		
//		private boolean steckdoseBereitsVorhanden;
		this.steckdoseBereitsVorhanden = "Steckdose bereits vorhanden: " + formatiranjeJaOderNein( blatt.isSteckdoseBereitsVorhanden());
//		private boolean bohrschabloneAngebract;
		this.bohrschabloneAngebract = "Bohrschablone angebract: " + formatiranjeJaOderNein( blatt.isBohrschabloneAngebract());
		
		this.auftragsNumer = "Auftragsnummer: " + formatiranjePropertija( blatt.getAuftragsNumer());
		this.lgNrGateway = "Lg-Nr. Gateway: " + formatiranjePropertija( blatt.getLgNrGateway());
		this.plz = "PLZ: " + formatiranjePropertija( blatt.getPlz());
		this.ort = "Ort: " + formatiranjePropertija( blatt.getOrt());
		this.strasse = "Straße: " + formatiranjePropertija( blatt.getStrasse());
		
		if(isLongIzBaze(blatt.getMontageDatum())) {
			this.montageDatum = "Montagedatum: " + formatiranjeDatuma( new Date( formatiranjeStringLongDatum(blatt.getMontageDatum())));//Long.parseLong(blatt.getMontageDatum())));
		}else {
			this.montageDatum = "Montagedatum: " ;
		}
		
		this.servicePartnerNr = "Servicepartner Nr: " + formatiranjePropertija( blatt.getServicePartnerNr());
		
//		private String unterschiftServicePartner; -  staviti username kosinika
//		private String bemerkungenZurMontage;
		this.bemerkungenZurMontage = "Bemerkungen Zur Montage: " + formatiranjePropertija(blatt.getBemerkungenZurMontage());
//		private String beiHybridInstallationLfdNrDesGateways;
		this.beiHybridInstallationLfdNrDesGateways = "Lcd Nr. des Gateways: " + formatiranjePropertija(blatt.getBeiHybridInstallationLfdNrDesGateways());
//		private String beiHybridInstallationLMontagepositionDerAntenne;
		this.beiHybridInstallationLMontagepositionDerAntenne = "Montageposition Der Antenne: " + formatiranjePropertija(blatt.getBeiHybridInstallationLMontagepositionDerAntenne());
//		private String beiHybridInstallationSonstigeBemerkung;
		this.beiHybridInstallationSonstigeBemerkung = "Sonstige Bemerkung: " + formatiranjePropertija(blatt.getBeiHybridInstallationSonstigeBemerkung());
//		private Date startdatum;
		this.startdatum = "Datum der Eingabe: " + formatiranjeDatuma(blatt.getStartdatum());
		
		this.blattLtdnr = blatt.getLtdnr() != null ? new ArrayList<>( blatt.getLtdnr()) : new ArrayList<BlattLtdnr>();
		this.ispisLtdnr = pripremiListuLtdnrZaIspis(this.blattLtdnr);
		
	}
	
	private List<IspisBlattLtdnr> pripremiListuLtdnrZaIspis(List<BlattLtdnr> blattLtdnr2) {
		
		List<IspisBlattLtdnr> noviIspisLtdnrList = new ArrayList<>();
		
		for (int i = 0; i < blattLtdnr2.size(); i++) {
			 IspisBlattLtdnr novi = new IspisBlattLtdnr(blattLtdnr2.get(i));
			 noviIspisLtdnrList.add(novi);
		}
		
		return noviIspisLtdnrList;
	}

	//Datum primimo ako je 1970 znači da je metoda za formatiranje datum iz string bacila number exception
	//pa smo onda vratili new Date(0)
	// Ako dobije null - tj nismo nista unjeli na polja datuma vrtimo prazan string ""
	private String formatiranjeDatuma(Date time) {
		// TODO Auto-generated method stub
		if(time != null) {
			
			String year = dateFormatYear.format(time);
			if(year.contains("1970")) {
				return "";
				
			}else {
				Date datum = time != null ? time : new Date();
				return dateFormat.format(datum);
			}
		}else {
			return "";
		}
		
		
	}


	private String formatiranjeJaOderNein(boolean mobil) {
		String jaOderNein = mobil == true ? "Ja" : "Nein";
		return jaOderNein;
	}


	private String formatiranjePropertija(String property) {
		
		  String st = property != null ? property : "";
		  return st;
	}
	
	private Long formatiranjeStringLongDatum(String datumIzBaze) {
		
	  
	  try {
          return Long.parseLong(datumIzBaze);
      } catch (NumberFormatException exception) {
          // Output expected NumberFormatException.
    	  //TODO Napraviti Logging
          System.out.println("datum nije u formatu long");
          return new Long(0);
      }
	  
	}
	
	
	
	public String getNaslov1() {
		return naslov1;
	}
	public long getId() {
		return id;
	}
	public String getAdresseDesObjektes() {
		return adresseDesObjektes;
	}
	public String getLgNr() {
		return lgNr;
	}
	public String getAnsprechperson() {
		return ansprechperson;
	}
	public String getTelNrAnsprechenperson() {
		return telNrAnsprechenperson;
	}
	public String isMobilfunkverbindungVorhanden() {
		return mobilfunkverbindungVorhanden;
	}
	public String getBegehungsdatum() {
		return begehungsdatum;
	}
	public String getBausubstanz() {
		return bausubstanz;
	}
	public String getAuftragsnummer() {
		return auftragsnummer;
	}
	public String getAussenbereichVorderseite() {
		return aussenbereichVorderseite;
	}
	public String getAussenbereichHinterseite() {
		return aussenbereichHinterseite;
	}
	public String getAussenbereichLinkeseite() {
		return aussenbereichLinkeseite;
	}
	public String getAussenbereichRechteseite() {
		return aussenbereichRechteseite;
	}
	public String getInnenbereichEingangLinksOben() {
		return innenbereichEingangLinksOben;
	}
	public String getInnenbereichEingangMittigOben() {
		return innenbereichEingangMittigOben;
	}
	public String getInnenbereichEingangRechtsOben() {
		return innenbereichEingangRechtsOben;
	}
	public String getInnenbereichEingangLinksUnten() {
		return innenbereichEingangLinksUnten;
	}
	public String getInnenbereichEingangMittigUnten() {
		return innenbereichEingangMittigUnten;
	}
	public String getInnenbereichEingangRechtsUnten() {
		return innenbereichEingangRechtsUnten;
	}
	public String getWeitereMessstellenHeizraum() {
		return weitereMessstellenHeizraum;
	}
	public String getWeitereMessstellenWaschkuche() {
		return weitereMessstellenWaschkuche;
	}
	public String getWeitereMessstellenAnderes1() {
		return weitereMessstellenAnderes1;
	}
	public String getWeitereMessstellen1() {
		return weitereMessstellen1;
	}
	public String getWeitereMessstellenAnderes2() {
		return weitereMessstellenAnderes2;
	}
	public String getWeitereMessstellen2() {
		return weitereMessstellen2;
	}
	public String getWeitereMessstellenAnderes3() {
		return weitereMessstellenAnderes3;
	}
	public String getWeitereMessstellen3() {
		return weitereMessstellen3;
	}
	public String getWeitereMessstellenAnderes4() {
		return weitereMessstellenAnderes4;
	}
	public String getWeitereMessstellen4() {
		return weitereMessstellen4;
	}
	public String getMontageortDesGatewaysAdresse() {
		return montageortDesGatewaysAdresse;
	}
	public String getMontageortDesGatewaysHausnummer() {
		return montageortDesGatewaysHausnummer;
	}
	public String getMontageortDesGatewaysRaumbezeichung() {
		return montageortDesGatewaysRaumbezeichung;
	}
	public String isSteckdoseBereitsVorhanden() {
		return steckdoseBereitsVorhanden;
	}
	public String isBohrschabloneAngebract() {
		return bohrschabloneAngebract;
	}
	public boolean isUsername() {
		return username;
	}
	public String getAuftragsNumer() {
		return auftragsNumer;
	}
	public String getLgNrGateway() {
		return lgNrGateway;
	}
	public String getPlz() {
		return plz;
	}
	public String getOrt() {
		return ort;
	}
	public String getStrasse() {
		return strasse;
	}
	public String getMontageDatum() {
		return montageDatum;
	}
	public String getServicePartnerNr() {
		return servicePartnerNr;
	}
	public String getUnterschiftServicePartner() {
		return unterschiftServicePartner;
	}
	public String getBemerkungenZurMontage() {
		return bemerkungenZurMontage;
	}
	public String getBeiHybridInstallationLfdNrDesGateways() {
		return beiHybridInstallationLfdNrDesGateways;
	}
	public String getBeiHybridInstallationLMontagepositionDerAntenne() {
		return beiHybridInstallationLMontagepositionDerAntenne;
	}
	public String getBeiHybridInstallationSonstigeBemerkung() {
		return beiHybridInstallationSonstigeBemerkung;
	}
	public String getStartdatum() {
		return startdatum;
	}


	public String getAusenbereich() {
		return ausenbereich;
	}


	public String getInnenbereich() {
		return innenbereich;
	}


	public String getWeitereMessstellen() {
		return weitereMessstellen;
	}


	public String getMontageOrt() {
		return montageOrt;
	}


	public String getMacAdresseBlatt1() {
		return macAdresseBlatt1;
	}


	public List<BlattLtdnr> getBlattLtdnr() {
		return blattLtdnr;
	}


	public void setBlattLtdnr(List<BlattLtdnr> blattLtdnr) {
		this.blattLtdnr = blattLtdnr;
	}


	public List<IspisBlattLtdnr> getIspisLtdnr() {
		return ispisLtdnr;
	}


	public void setIspisLtdnr(List<IspisBlattLtdnr> ispisLtdnr) {
		this.ispisLtdnr = ispisLtdnr;
	}
	
	
	/** Provjeravamo jeli long u bazi za polje gdje je datum*/
	private boolean isLongIzBaze (String datumIzBaze) {
		try {
			long l = Long.parseLong(datumIzBaze);
		} catch (NumberFormatException e) {
			return false;
		}
		    return true;
	}



}
