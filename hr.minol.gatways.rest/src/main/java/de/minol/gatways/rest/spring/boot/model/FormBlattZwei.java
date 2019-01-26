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


@Entity(name = "blatt")
public class FormBlattZwei {

private final static String descriptionGatewayNummer = "MAC Addresse nur vollstandig eintragen";
	
	/**
	 * 
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Column(name = "ordungsnummer")
    private String ordungsnummer;
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
	
	@OneToMany(mappedBy = "formBlattZwei", cascade = CascadeType.ALL)
	private Set<BlattZweiLtdnr> ltdnr;
	
//    public Set<BlattZweiLtdnr> getLtdnr() {
//        return ltdnr;
//    }
//
//    public void setLtdnr(Set<BlattZweiLtdnr> ltdnr) {
//        this.ltdnr = ltdnr;
//    }

	
	
	
	
	
	public String getOrdungsnummer() {
		return ordungsnummer;
	}
	public void setOrdungsnummer(String ordungsnummer) {
		this.ordungsnummer = ordungsnummer;
	}
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
	public Set<BlattZweiLtdnr> getLtdnr() {
		return ltdnr;
	}
	public void setLtdnr(Set<BlattZweiLtdnr> ltdnr) {
		this.ltdnr = ltdnr;
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
	
}
