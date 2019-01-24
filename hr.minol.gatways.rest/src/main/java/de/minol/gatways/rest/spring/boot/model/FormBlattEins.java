package de.minol.gatways.rest.spring.boot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Formblatteins")
public class FormBlattEins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "ordnungsnummer")
	private String ordnungsNummer;
	@Column(name = "adressedesobjektes")
	private String adresseDesObjektes;
	@Column(name = "lgnr")
	private String lgNr;
	@Column(name = "ansprechperson")
	private String ansprechperson;
	@Column(name = "telnransprechenperson")
	private String telNrAnsprechenperson;
	@Column(name = "mobilfunkverbindungvorhanden")
	private boolean mobilfunkverbindungVorhanden;
	@Column(name = "begehungsdatum")
	@Temporal( TemporalType.TIMESTAMP)
	private Date begehungsdatum;
	@Column(name = "bausubstanz")
	private String bausubstanz;
	@Column(name = "auftragsnummer")
	private String auftragsnummer;
	@Column(name = "aussenbereichvorderseite")
	private String aussenbereichVorderseite;
	@Column(name = "aussenbereichhinterseite")
	private String aussenbereichHinterseite;
	@Column(name = "aussenbereichlinkeseite")
	private String aussenbereichLinkeseite;
	@Column(name = "aussenbereichrechteseite")
	private String aussenbereichRechteseite;
	@Column(name = "innenbereicheinganglinksoben")
	private String innenbereichEingangLinksOben;
	@Column(name = "innenbereicheingangmittigoben")
	private String innenbereichEingangMittigOben;
	@Column(name = "innenbereicheingangrechtsoben")
	private String innenbereichEingangRechtsOben;
	@Column(name = "innenbereicheinganglinksunten")
	private String innenbereichEingangLinksUnten;
	@Column(name = "innenbereicheingangmittigunten")
	private String innenbereichEingangMittigUnten;
	@Column(name = "innenbereicheingangrechtsunten")
	private String innenbereichEingangRechtsUnten;
	@Column(name = "weiteremessstellenheizraum")
	private String weitereMessstellenHeizraum;
	@Column(name = "weiteremessstellenwaschkuche")
	private String weitereMessstellenWaschkuche;
	
	// private List<Empfang> weitereMestelle;
	@Column(name = "weiteremessstellenanderes1")
	private String weitereMessstellenAnderes1;
	@Column(name = "weiteremessstellen1")
	private String weitereMessstellen1;
	@Column(name = "weiteremessstellenanderes2")
	private String weitereMessstellenAnderes2;
	@Column(name = "weiteremessstellen2")
	private String weitereMessstellen2;
	@Column(name = "weiteremessstellenanderes3")
	private String weitereMessstellenAnderes3;
	@Column(name = "weiteremessstellen3")
	private String weitereMessstellen3;
	@Column(name = "weiteremessstellenanderes4")
	private String weitereMessstellenAnderes4;
	@Column(name = "weiteremessstellen4")
	private String weitereMessstellen4;
	
	@Column(name = "montageortdesgatewaysadresse")
	private String montageortDesGatewaysAdresse;
	@Column(name = "montageortdesgatewayshausnummer")
	private String montageortDesGatewaysHausnummer;
	@Column(name = "montageortdesgatewaysraumbezeichung")
	private String montageortDesGatewaysRaumbezeichung;
	
	@Column(name = "steckdosebereitsvorhanden")
	private boolean steckdoseBereitsVorhanden;
	@Column(name = "bohrschabloneangebract")
	private boolean bohrschabloneAngebract;
	@Column(name = "startdatum")
	@Temporal( TemporalType.TIMESTAMP)
	private Date startdatum;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrdnungsNummer() {
		return ordnungsNummer;
	}
	public void setOrdnungsNummer(String ordnungsNummer) {
		this.ordnungsNummer = ordnungsNummer;
	}
	public String getAdresseDesObjektes() {
		return adresseDesObjektes;
	}
	public void setAdresseDesObjektes(String adresseDesObjektes) {
		this.adresseDesObjektes = adresseDesObjektes;
	}
	public String getLgNr() {
		return lgNr;
	}
	public void setLgNr(String lgNr) {
		this.lgNr = lgNr;
	}
	public String getAnsprechperson() {
		return ansprechperson;
	}
	public void setAnsprechperson(String ansprechperson) {
		this.ansprechperson = ansprechperson;
	}
	public String getTelNrAnsprechenperson() {
		return telNrAnsprechenperson;
	}
	public void setTelNrAnsprechenperson(String telNrAnsprechenperson) {
		this.telNrAnsprechenperson = telNrAnsprechenperson;
	}
	public boolean isMobilfunkverbindungVorhanden() {
		return mobilfunkverbindungVorhanden;
	}
	public void setMobilfunkverbindungVorhanden(boolean mobilfunkverbindungVorhanden) {
		this.mobilfunkverbindungVorhanden = mobilfunkverbindungVorhanden;
	}
	public Date getBegehungsdatum() {
		return begehungsdatum;
	}
	public void setBegehungsdatum(Date begehungsdatum) {
		this.begehungsdatum = begehungsdatum;
	}
	
	
	
	public Bausubstanz getBausubstanz() {
		return bausubstanz != null ? Bausubstanz.parse( bausubstanz ) : null;
	}
	public void setBausubstanz(Bausubstanz bausubstanz) {
		 this.bausubstanz = bausubstanz != null ? bausubstanz.getSifra() : null;
	}
	
	public String getAuftragsnummer() {
		return auftragsnummer;
	}
	public void setAuftragsnummer(String auftragsnummer) {
		this.auftragsnummer = auftragsnummer;
	}
	

	public Empfang getAussenbereichVorderseite() {
		return aussenbereichVorderseite != null ? Empfang.parse( aussenbereichVorderseite ) : null;
	}
	public void setAussenbereichVorderseite(Empfang aussenbereichVorderseite) {
		 this.aussenbereichVorderseite = aussenbereichVorderseite != null ? aussenbereichVorderseite.getSifra() : null;
	}
	
	public Empfang getAussenbereichHinterseite() {
		 return aussenbereichHinterseite != null ? Empfang.parse( aussenbereichHinterseite ) : null;
	}
	public void setAussenbereichHinterseite(Empfang aussenbereichHinterseite) {
		this.aussenbereichHinterseite = aussenbereichHinterseite != null ? aussenbereichHinterseite.getSifra() : null;
	}
	
	public Empfang getAussenbereichLinkeseite() {
		return aussenbereichLinkeseite != null ? Empfang.parse( aussenbereichLinkeseite ) : null;
	}
	public void setAussenbereichLinkeseite(Empfang aussenbereichLinkeseite) {
		this.aussenbereichLinkeseite = aussenbereichLinkeseite != null ? aussenbereichLinkeseite.getSifra() : null;
	}
	public Empfang getAussenbereichRechteseite() {
		return aussenbereichLinkeseite != null ? Empfang.parse( aussenbereichLinkeseite ) : null;
	}
	
	public void setAussenbereichRechteseite(Empfang aussenbereichRechteseite) {
		this.aussenbereichRechteseite = aussenbereichRechteseite != null ? aussenbereichRechteseite.getSifra() : null;
	}
	public Empfang getInnenbereichEingangLinksOben() {
		return innenbereichEingangLinksOben != null ? Empfang.parse( innenbereichEingangLinksOben ) : null;
	}
	public void setInnenbereichEingangLinksOben(Empfang innenbereichEingangLinksOben) {
		this.innenbereichEingangLinksOben = innenbereichEingangLinksOben != null ? innenbereichEingangLinksOben.getSifra() : null;
	}
	public Empfang getInnenbereichEingangMittigOben() {
		return innenbereichEingangMittigOben != null ? Empfang.parse( innenbereichEingangMittigOben ) : null;
	}
	public void setInnenbereichEingangMittigOben(Empfang innenbereichEingangMittigOben) {
		this.innenbereichEingangMittigOben = innenbereichEingangMittigOben != null ? innenbereichEingangMittigOben.getSifra() : null;
	}
	public Empfang getInnenbereichEingangRechtsOben() {
		return innenbereichEingangRechtsOben != null ? Empfang.parse( innenbereichEingangRechtsOben ) : null;
	}
	public void setInnenbereichEingangRechtsOben(Empfang innenbereichEingangRechtsOben) {
		this.innenbereichEingangRechtsOben = innenbereichEingangRechtsOben != null ? innenbereichEingangRechtsOben.getSifra() : null;
	}
	public Empfang getInnenbereichEingangLinksUnten() {
		return innenbereichEingangLinksUnten != null ? Empfang.parse( innenbereichEingangLinksUnten ) : null;
	}
	public void setInnenbereichEingangLinksUnten(Empfang innenbereichEingangLinksUnten) {
		this.innenbereichEingangLinksUnten = innenbereichEingangLinksUnten != null ? innenbereichEingangLinksUnten.getSifra() : null;
	}
	public Empfang getInnenbereichEingangMittigUnten() {
		return innenbereichEingangMittigUnten != null ? Empfang.parse( innenbereichEingangMittigUnten ) : null;
	}
	public void setInnenbereichEingangMittigUnten(Empfang innenbereichEingangMittigUnten) {
		this.innenbereichEingangMittigUnten = innenbereichEingangMittigUnten != null ? innenbereichEingangMittigUnten.getSifra() : null;
	}
	public Empfang getInnenbereichEingangRechtsUnten() {
		return innenbereichEingangRechtsUnten != null ? Empfang.parse( innenbereichEingangRechtsUnten ) : null;
	}
	public void setInnenbereichEingangRechtsUnten(Empfang innenbereichEingangRechtsUnten) {
		this.innenbereichEingangRechtsUnten = innenbereichEingangMittigOben != null ? innenbereichEingangRechtsUnten.getSifra() : null;
	}
	public Empfang getWeitereMessstellenHeizraum() {
		return weitereMessstellenHeizraum != null ? Empfang.parse( weitereMessstellenHeizraum ) : null;
	}
	public void setWeitereMessstellenHeizraum(Empfang weitereMessstellenHeizraum) {
		this.weitereMessstellenHeizraum = weitereMessstellenHeizraum != null ? weitereMessstellenHeizraum.getSifra() : null;
	}
	public Empfang getWeitereMessstellenWaschkuche() {
		return weitereMessstellenWaschkuche != null ? Empfang.parse( weitereMessstellenWaschkuche ) : null;
	}
	public void setWeitereMessstellenWaschkuche(Empfang weitereMessstellenWaschkuche) {
		this.weitereMessstellenWaschkuche = weitereMessstellenWaschkuche != null ? weitereMessstellenWaschkuche.getSifra() : null;
	}
	public Empfang getWeitereMessstellenAnderes1() {
		return weitereMessstellenAnderes1 != null ? Empfang.parse( weitereMessstellenAnderes1 ) : null;
	}
	public void setWeitereMessstellenAnderes1(Empfang weitereMessstellenAnderes1) {
		this.weitereMessstellenAnderes1 = weitereMessstellenAnderes1 != null ? weitereMessstellenAnderes1.getSifra() : null;
	}
	public Empfang getWeitereMessstellenAnderes2() {
		return weitereMessstellenAnderes2 != null ? Empfang.parse( weitereMessstellenAnderes2 ) : null;
	}
	public void setWeitereMessstellenAnderes2(Empfang weitereMessstellenAnderes2) {
		this.weitereMessstellenAnderes2 = weitereMessstellenAnderes2 != null ? weitereMessstellenAnderes2.getSifra() : null;
	}
	public Empfang getWeitereMessstellenAnderes3() {
		return weitereMessstellenAnderes3 != null ? Empfang.parse( weitereMessstellenAnderes3 ) : null;
	}
	public void setWeitereMessstellenAnderes3(Empfang weitereMessstellenAnderes3) {
		this.weitereMessstellenAnderes3 = weitereMessstellenAnderes3 != null ? weitereMessstellenAnderes3.getSifra() : null;
	}
	public Empfang getWeitereMessstellenAnderes4() {
		return weitereMessstellenAnderes4 != null ? Empfang.parse( weitereMessstellenAnderes4 ) : null;
	}
	public void setWeitereMessstellenAnderes4(Empfang weitereMessstellenAnderes4) {
		this.weitereMessstellenAnderes4 = weitereMessstellenAnderes4 != null ? weitereMessstellenAnderes4.getSifra() : null;
	}
	public String getMontageortDesGatewaysAdresse() {
		return montageortDesGatewaysAdresse;
	}
	public void setMontageortDesGatewaysAdresse(String montageortDesGatewaysAdresse) {
		this.montageortDesGatewaysAdresse = montageortDesGatewaysAdresse;
	}
	public String getMontageortDesGatewaysHausnummer() {
		return montageortDesGatewaysHausnummer;
	}
	public void setMontageortDesGatewaysHausnummer(String montageortDesGatewaysHausnummer) {
		this.montageortDesGatewaysHausnummer = montageortDesGatewaysHausnummer;
	}
	public String getMontageortDesGatewaysRaumbezeichung() {
		return montageortDesGatewaysRaumbezeichung;
	}
	public void setMontageortDesGatewaysRaumbezeichung(String montageortDesGatewaysRaumbezeichung) {
		this.montageortDesGatewaysRaumbezeichung = montageortDesGatewaysRaumbezeichung;
	}
	public boolean isSteckdoseBereitsVorhanden() {
		return steckdoseBereitsVorhanden;
	}
	public void setSteckdoseBereitsVorhanden(boolean steckdoseBereitsVorhanden) {
		this.steckdoseBereitsVorhanden = steckdoseBereitsVorhanden;
	}
	public boolean isBohrschabloneAngebract() {
		return bohrschabloneAngebract;
	}
	public void setBohrschabloneAngebract(boolean bohrschabloneAngebract) {
		this.bohrschabloneAngebract = bohrschabloneAngebract;
	}
	public String getWeitereMessstellen1() {
		return weitereMessstellen1;
	}
	public void setWeitereMessstellen1(String weitereMessstellen1) {
		this.weitereMessstellen1 = weitereMessstellen1;
	}
	public String getWeitereMessstellen2() {
		return weitereMessstellen2;
	}
	public void setWeitereMessstellen2(String weitereMessstellen2) {
		this.weitereMessstellen2 = weitereMessstellen2;
	}
	public String getWeitereMessstellen3() {
		return weitereMessstellen3;
	}
	public void setWeitereMessstellen3(String weitereMessstellen3) {
		this.weitereMessstellen3 = weitereMessstellen3;
	}
	public String getWeitereMessstellen4() {
		return weitereMessstellen4;
	}
	public void setWeitereMessstellen4(String weitereMessstellen4) {
		this.weitereMessstellen4 = weitereMessstellen4;
	}
	public Date getStartdatum() {
		return startdatum;
	}
	public void setStartdatum(Date startdatum) {
		this.startdatum = startdatum;
	}

}
