package de.minol.gatways.rest.spring.boot.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "Formblatt")
public class FormBlatt {

private final static String descriptionGatewayNummer = "MAC Addresse nur vollstandig eintragen";
	
	/**
	 * 
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Column(name = "macadresseblatt1")
	private String macAdresseBlatt1;
    @Column(name = "adressedesobjektes")
	private String adresseDesObjektes;
	@Column(name = "lgnr")
	private String lgNr;
	@Column(name = "ansprechperson")
	private String ansprechperson;
	@Column(name = "telnransprechenperson")
	private String telNrAnsprechenperson;
	@Column(name = "mobilfunkverbindungvorhanden")
	private String mobilfunkverbindungVorhanden;
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
	private String steckdoseBereitsVorhanden;
	@Column(name = "bohrschabloneangebract")
	private String bohrschabloneAngebract;
	@Column(name = "username")
	private String username;
	
   
	@Column(name = "auftragsnumer")
    private String auftragsNumer;
	@Column(name = "lgnrgateway")
	private String lgNrGateway;
	@Column(name = "plz")
	private String plz;
	@Column(name = "ort")
	private String ort;
	@Column(name = "strasse")
	private String strasse;
	@Column(name = "montagedatum")
	private String montageDatum;
	@Column(name = "servicepartnernr")
	private String servicePartnerNr;
	@Column(name = "unterschiftservicepartner")
	private String unterschiftServicePartner;
	@Column(name = "bemerkungenzurmontage")
	private String bemerkungenZurMontage;
	@Column(name = "beihybridinstallationlfdnrdesgateways")
	private String beiHybridInstallationLfdNrDesGateways;
	@Column(name = "beihybridinstallationlmontagepositionderantenne")
	private String beiHybridInstallationLMontagepositionDerAntenne;
	@Column(name = "beihybridinstallationsonstigebemerkung")
	private String beiHybridInstallationSonstigeBemerkung;
	@Column(name = "startdatum")
	@Temporal( TemporalType.TIMESTAMP)
	private Date startdatum;
	
	
	
//	@OneToMany(targetEntity=BlattZweiLtdnr.class, mappedBy = "formBlattZwei", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//	private List<BlattZweiLtdnr> ltdnr;
	
	@OneToMany(mappedBy = "formBlatt", cascade = CascadeType.ALL)
	private Set<BlattLtdnr> ltdnr;
	
//    public Set<BlattZweiLtdnr> getLtdnr() {
//        return ltdnr;
//    }
//
//    public void setLtdnr(Set<BlattZweiLtdnr> ltdnr) {
//        this.ltdnr = ltdnr;
//    }

	
	
	
	
	
	
	public String getAuftragsNumer() {
		return auftragsNumer;
	}
	public void setAuftragsNumer(String auftragsNumer) {
		this.auftragsNumer = auftragsNumer;
	}
	public String getLgNrGateway() {
		return lgNrGateway;
	}
	public void setLgNrGateway(String lgNrGateway) {
		this.lgNrGateway = lgNrGateway;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getMontageDatum() {
		return montageDatum;
	}
	public void setMontageDatum(String montageDatum) {
		this.montageDatum = montageDatum;
	}
	public String getServicePartnerNr() {
		return servicePartnerNr;
	}
	public void setServicePartnerNr(String servicePartnerNr) {
		this.servicePartnerNr = servicePartnerNr;
	}
	public String getUnterschiftServicePartner() {
		return unterschiftServicePartner;
	}
	public void setUnterschiftServicePartner(String unterschiftServicePartner) {
		this.unterschiftServicePartner = unterschiftServicePartner;
	}
	public String getBemerkungenZurMontage() {
		return bemerkungenZurMontage;
	}
	public void setBemerkungenZurMontage(String bemerkungenZurMontage) {
		this.bemerkungenZurMontage = bemerkungenZurMontage;
	}
	public String getBeiHybridInstallationLfdNrDesGateways() {
		return beiHybridInstallationLfdNrDesGateways;
	}
	public void setBeiHybridInstallationLfdNrDesGateways(String beiHybridInstallationLfdNrDesGateways) {
		this.beiHybridInstallationLfdNrDesGateways = beiHybridInstallationLfdNrDesGateways;
	}
	public String getBeiHybridInstallationLMontagepositionDerAntenne() {
		return beiHybridInstallationLMontagepositionDerAntenne;
	}
	public void setBeiHybridInstallationLMontagepositionDerAntenne(String beiHybridInstallationLMontagepositionDerAntenne) {
		this.beiHybridInstallationLMontagepositionDerAntenne = beiHybridInstallationLMontagepositionDerAntenne;
	}
	public String getBeiHybridInstallationSonstigeBemerkung() {
		return beiHybridInstallationSonstigeBemerkung;
	}
	public void setBeiHybridInstallationSonstigeBemerkung(String beiHybridInstallationSonstigeBemerkung) {
		this.beiHybridInstallationSonstigeBemerkung = beiHybridInstallationSonstigeBemerkung;
	}
	public static String getDescriptiongatewaynummer() {
		return descriptionGatewayNummer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
//	public List<BlattZweiLtdnr> getLtdnr() {
//		return ltdnr;
//	}
//	public void setLtdnr(List<BlattZweiLtdnr> ltdnr) {
//		this.ltdnr = ltdnr;
//	}
	public Date getStartdatum() {
		return startdatum;
	}
	public void setStartdatum(Date startdatum) {
		this.startdatum = startdatum;
	}
	
	//Blatt Eins
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
	public String getMobilfunkverbindungVorhanden() {
		return mobilfunkverbindungVorhanden;
	}
	public void setMobilfunkverbindungVorhanden(String mobilfunkverbindungVorhanden) {
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
	public String getSteckdoseBereitsVorhanden() {
		return steckdoseBereitsVorhanden;
	}
	public void setSteckdoseBereitsVorhanden(String steckdoseBereitsVorhanden) {
		this.steckdoseBereitsVorhanden = steckdoseBereitsVorhanden;
	}
	public String getBohrschabloneAngebract() {
		return bohrschabloneAngebract;
	}
	public void setBohrschabloneAngebract(String bohrschabloneAngebract) {
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
	public Set<BlattLtdnr> getLtdnr() {
		return ltdnr;
	}
	public void setLtdnr(Set<BlattLtdnr> ltdnr) {
		this.ltdnr = ltdnr;
	}
	public String getMacAdresseBlatt1() {
		return macAdresseBlatt1;
	}
	public void setMacAdresseBlatt1(String macAdresseBlatt1) {
		this.macAdresseBlatt1 = macAdresseBlatt1;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
