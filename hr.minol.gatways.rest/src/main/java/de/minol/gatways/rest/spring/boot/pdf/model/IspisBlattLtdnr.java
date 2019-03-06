package de.minol.gatways.rest.spring.boot.pdf.model;

import de.minol.gatways.rest.spring.boot.model.BlattLtdnr;

public class IspisBlattLtdnr{
	
	private String ltdnr;
	private String gatewaynummerAlt;
	private String gatewayNummerNeu;
	private String abwAnscriftHauseingang;
	private String geschloss;
	private String lage;
	private String montagePositionRaum;
	private String montageort;
	private String power;
	private String lora;
	private String usb;
	private String sapNr;
	
	public IspisBlattLtdnr(BlattLtdnr ltdnr) {
		
		this.ltdnr = ltdnr.getLtdnr();
		this.gatewaynummerAlt = ltdnr.getGatewaynummerAlt();
		this.gatewayNummerNeu = ltdnr.getGatewayNummerNeu();
		this.abwAnscriftHauseingang = ltdnr.getAbwAnscriftHauseingang();
		this.geschloss = ltdnr.getGeschloss().getOpis();
		this.lage = ltdnr.getLage().getOpis();
		String positionHinweis = ltdnr.getMontagePositionRaumhinweis() != null 
				? ltdnr.getMontagePositionRaumhinweis() : "";
		this.montagePositionRaum = ltdnr.getMontagePositionRaum().getOpis() + " " + positionHinweis;
		this.montageort = ltdnr.getMontageort().getOpis();
		this.power = ltdnr.getPower().getOpis();
		this.lora = ltdnr.getLora().getOpis();
		this.usb = ltdnr.getUsb().getOpis();
		this.sapNr = ltdnr.getSapNr();
	}

	public String getLtdnr() {
		return ltdnr;
	}

	public void setLtdnr(String ltdnr) {
		this.ltdnr = ltdnr;
	}

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

	public String getGeschloss() {
		return geschloss;
	}

	public void setGeschloss(String geschloss) {
		this.geschloss = geschloss;
	}

	public String getLage() {
		return lage;
	}

	public void setLage(String lage) {
		this.lage = lage;
	}

	public String getMontagePositionRaum() {
		return montagePositionRaum;
	}

	public void setMontagePositionRaum(String montagePositionRaum) {
		this.montagePositionRaum = montagePositionRaum;
	}

	public String getMontageort() {
		return montageort;
	}

	public void setMontageort(String montageort) {
		this.montageort = montageort;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getLora() {
		return lora;
	}

	public void setLora(String lora) {
		this.lora = lora;
	}

	public String getUsb() {
		return usb;
	}

	public void setUsb(String usb) {
		this.usb = usb;
	}

	public String getSapNr() {
		return sapNr;
	}

	public void setSapNr(String sapNr) {
		this.sapNr = sapNr;
	}
	
}
