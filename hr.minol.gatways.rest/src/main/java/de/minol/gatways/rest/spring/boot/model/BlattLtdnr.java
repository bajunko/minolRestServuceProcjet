package de.minol.gatways.rest.spring.boot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Blattltdnr")
public class BlattLtdnr {

	
	/**
	 * 
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Column(name = "ltdnr")
	private String ltdnr;
	@Column(name = "gatewaynummeralt")
	private String gatewaynummerAlt;
	@Column(name = "gatewaynummerneu")
	private String gatewayNummerNeu;
	@Column(name = "abwanscrifthauseingang")
	private String abwAnscriftHauseingang;
	@Column(name = "geschloss")
	private String geschloss;
	@Column(name = "lage")
	private String lage;
	@Column(name = "montagepositionraum")
	private String montagePositionRaum;
	@Column(name = "montageort")
	private String montageort;
	@Column(name = "power")
	private String power;
	@Column(name = "lora")
	private String lora;
	@Column(name = "usb")
	private String usb;
	@Column(name = "sapnr")
	private String sapNr;
	//Dodatne napomene za svako polje koje dropdown - koje su u modelu enumeracija
	// Hinweis
	@Column(name = "geschlosshinweis")
	private String geschlosshinweis;
	@Column(name = "lagehinweis")
	private String lagehinweis;
	@Column(name = "montagepositionraumhinweis")
	private String montagePositionRaumhinweis;
	@Column(name = "montageorthinweis")
	private String montageorthinweis;
	@Column(name = "powerhinweis")
	private String powerhinweis;
	@Column(name = "lorahinweis")
	private String lorahinweis;
	@Column(name = "usbhinweis")
	private String usbhinweis;
	
//	 @Column(name = "formblattzwei_id")
//     private String formblattzwei_id;
	
//	@Column(name = "id")
//	private FormBlattZwei formBlattZwei;
	
//	 @ManyToOne
//	    @JoinColumn(name = "id")
//	    public FormBlattZwei getFormBlattZwei() {
//	        return formBlattZwei;
//	    }
//
//	    public void setFormBlattZwei(FormBlattZwei formBlattZwei) {
//	        this.formBlattZwei = formBlattZwei;
//	    }
	
	   private transient Long formblatt_id;

	    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "formblatt_id", nullable = false)
	    @JsonIgnore
	    private FormBlatt formBlatt;
	
	
	
	public String getGatewaynummerAlt() {
		return gatewaynummerAlt;
	}
	public void setGatewaynummerAlt(String gatewaynummerAlt) {
		this.gatewaynummerAlt = gatewaynummerAlt;
	}
	public String getGatewayNummerNeu() {
		return gatewayNummerNeu;
	}
	public void setGatewayNummerNeu(String gatewayNummerNeu) {
		this.gatewayNummerNeu = gatewayNummerNeu;
	}
	public String getAbwAnscriftHauseingang() {
		return abwAnscriftHauseingang;
	}
	public void setAbwAnscriftHauseingang(String abwAnscriftHauseingang) {
		this.abwAnscriftHauseingang = abwAnscriftHauseingang;
	}
	public Geschloss getGeschloss() {
		return geschloss != null ? Geschloss.parse( geschloss ) : null;
	}
	public void setGeschloss(Geschloss geschloss) {
		 this.geschloss = geschloss != null ? geschloss.getSifra() : null;
	}
	public Lage getLage() {
		return lage != null ? Lage.parse( lage ) : null;
	}
	public void setLage(Lage lage) {
		 this.lage = lage != null ? lage.getSifra() : null;
	}
	public MontagePositionRaum getMontagePositionRaum() {
		return montagePositionRaum != null ? MontagePositionRaum.parse( montagePositionRaum ) : null;
	}
	public void setMontagePositionRaum(MontagePositionRaum montagePositionRaum) {
		 this.montagePositionRaum = montagePositionRaum != null ? montagePositionRaum.getSifra() : null;
	}
	public Montageort getMontageort() {
		return montageort != null ? Montageort.parse( montageort ) : null;
	}
	public void setMontageort(Montageort montageort) {
		 this.montageort = montageort != null ? montageort.getSifra() : null;
	}
	public LedStatus getPower() {
		return power != null ? LedStatus.parse( power ) : null;
	}
	public void setPower(LedStatus power) {
		 this.power = power != null ? power.getSifra() : null;
	}
	public LedStatus getLora() {
		return lora != null ? LedStatus.parse( lora ) : null;
	}
	public void setLora(LedStatus lora) {
		 this.lora = lora != null ? lora.getSifra() : null;
	}
	public LedStatus getUsb() {
		return usb != null ? LedStatus.parse( usb ) : null;
	}
	public void setUsb(LedStatus usb) {
		 this.usb = usb != null ? usb.getSifra() : null;
	}
	public String getSapNr() {
		return sapNr;
	}
	public void setSapNr(String sapNr) {
		this.sapNr = sapNr;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getLtdnr() {
		return ltdnr;
	}
	public void setLtdnr(String ltdnr) {
		this.ltdnr = ltdnr;
	}
	public FormBlatt getFormBlatt() {
		return formBlatt;
	}
	public void setFormBlatt(FormBlatt formBlatt) {
		this.formBlatt = formBlatt;
	}
	public Long getFormblatt_id() {
		return formblatt_id;
	}
	public void setFormblatt_id(Long formblatt_id) {
		this.formblatt_id = formblatt_id;
	}
	public String getGeschlosshinweis() {
		return geschlosshinweis;
	}
	public void setGeschlosshinweis(String geschlosshinweis) {
		this.geschlosshinweis = geschlosshinweis;
	}
	public String getLagehinweis() {
		return lagehinweis;
	}
	public void setLagehinweis(String lagehinweis) {
		this.lagehinweis = lagehinweis;
	}
	public String getMontagePositionRaumhinweis() {
		return montagePositionRaumhinweis;
	}
	public void setMontagePositionRaumhinweis(String montagePositionRaumhinweis) {
		this.montagePositionRaumhinweis = montagePositionRaumhinweis;
	}
	public String getMontageorthinweis() {
		return montageorthinweis;
	}
	public void setMontageorthinweis(String montageorthinweis) {
		this.montageorthinweis = montageorthinweis;
	}
	public String getPowerhinweis() {
		return powerhinweis;
	}
	public void setPowerhinweis(String powerhinweis) {
		this.powerhinweis = powerhinweis;
	}
	public String getLorahinweis() {
		return lorahinweis;
	}
	public void setLorahinweis(String lorahinweis) {
		this.lorahinweis = lorahinweis;
	}
	public String getUsbhinweis() {
		return usbhinweis;
	}
	public void setUsbhinweis(String usbhinweis) {
		this.usbhinweis = usbhinweis;
	}
		
		
	
}
