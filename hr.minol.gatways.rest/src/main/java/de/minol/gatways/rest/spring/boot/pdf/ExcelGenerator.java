package de.minol.gatways.rest.spring.boot.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import de.minol.gatways.rest.spring.boot.model.BlattLtdnr;
import de.minol.gatways.rest.spring.boot.model.FormBlatt;
import de.minol.gatways.rest.spring.boot.model.FormBlattEins;
import de.minol.gatways.rest.spring.boot.pdf.model.IspisBlatt;

public class ExcelGenerator {

	public static ByteArrayInputStream customersToExcel(List<FormBlattEins> customers) throws IOException {
		String[] COLUMNs = { "Id", "Name", "Address", "Age" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("Customers");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

			int rowIdx = 1;
			for (FormBlattEins customer : customers) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(customer.getId());
				row.createCell(1).setCellValue(customer.getAdresseDesObjektes());
				row.createCell(2).setCellValue(customer.getAuftragsnummer());

				Cell ageCell = row.createCell(3);
				ageCell.setCellValue(customer.getAnsprechperson());
				ageCell.setCellStyle(ageCellStyle);
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	public static ByteArrayInputStream generateExcelReport(List<FormBlatt> allBlatt) throws IOException {
		// Sci stupci na Blatt1
		List<String> columns = new ArrayList<>();
		columns.add("MAC Adresse");
		columns.add("Adresse Des\nObjektes");
		columns.add("Begehungsdatum");
		columns.add("Bausubstanz");
		columns.add("Auftragsnummer");

		columns.add("Ansprechperson");
		columns.add("TelNr\nAnsprechenperson");
		columns.add("Mobilfunk-\nverbindung\nvorhanden");

		columns.add("Vorderseite");
		columns.add("Hinterseite");
		columns.add("Linke Seite");
		columns.add("Rechte Seite");

		columns.add("Eingang\nLinks Oben");
		columns.add("Eingang\nMittig Oben");
		columns.add("Eingang\nRechts Oben");
		columns.add("Eingang\nLinks Unten");
		columns.add("Eingang\nMittig Unten");
		columns.add("Eingang\nRechts Unten");

		columns.add("Heizraum");
		columns.add("Waschkuche");
		columns.add("Messstelle 1");
		columns.add("Messstelle 2");
		columns.add("Messstelle 3");
		columns.add("Messstelle 4");

		columns.add("Montageort des\nGateways: Adresse");
		columns.add("Montageort des\nGateways: Hausnummer");
		columns.add("Montageort des\nGateways: Raumbezeichung");
		columns.add("Steckdose\nbereits\nvorhanden");
		columns.add("Bohrschablone\nangebract");

		Workbook excelIspis = new XSSFWorkbook();
		Sheet blatt1 = excelIspis.createSheet("Blatt1");
		Sheet blatt2 = excelIspis.createSheet("Blatt2");	
		Font headerFont = excelIspis.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.RED.getIndex());
		CellStyle headerCellStyle = excelIspis.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow = blatt1.createRow(0);
		headerRow.setHeight((short)1000);

		for (int i = 0; i < columns.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns.get(i));
			cell.setCellStyle(headerCellStyle);
		}

		int rowNum = 1;
		// -------------Blatt1----------------//
		for (FormBlatt blatt : allBlatt) {
			int j = 0;
			Row row = blatt1.createRow(rowNum++);
			row.createCell(j++).setCellValue(blatt.getMacAdresseBlatt1());
			row.createCell(j++).setCellValue(blatt.getAdresseDesObjektes());
			row.createCell(j++).setCellValue(IspisBlatt.formatiranjeDatuma(blatt.getBegehungsdatum()));
			row.createCell(j++).setCellValue(blatt.getBausubstanz() != null ? blatt.getBausubstanz().getOpis() : "");
			row.createCell(j++).setCellValue(blatt.getAuftragsnummer());

			row.createCell(j++).setCellValue(blatt.getAnsprechperson());
			row.createCell(j++).setCellValue(blatt.getTelNrAnsprechenperson());
			row.createCell(j++).setCellValue(blatt.isMobilfunkverbindungVorhanden() ? "JA" : "NEIN");

			row.createCell(j++).setCellValue(
					blatt.getAussenbereichVorderseite() != null ? blatt.getAussenbereichVorderseite().getOpis() : "");
			row.createCell(j++).setCellValue(
					blatt.getAussenbereichHinterseite() != null ? blatt.getAussenbereichHinterseite().getOpis() : "");
			row.createCell(j++).setCellValue(
					blatt.getAussenbereichLinkeseite() != null ? blatt.getAussenbereichLinkeseite().getOpis() : "");
			row.createCell(j++).setCellValue(
					blatt.getAussenbereichRechteseite() != null ? blatt.getAussenbereichRechteseite().getOpis() : "");

			row.createCell(j++)
					.setCellValue(blatt.getInnenbereichEingangLinksOben() != null
							? blatt.getInnenbereichEingangLinksOben().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getInnenbereichEingangMittigOben() != null
							? blatt.getInnenbereichEingangMittigOben().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getInnenbereichEingangRechtsOben() != null
							? blatt.getInnenbereichEingangRechtsOben().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getInnenbereichEingangLinksUnten() != null
							? blatt.getInnenbereichEingangLinksUnten().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getInnenbereichEingangMittigUnten() != null
							? blatt.getInnenbereichEingangMittigUnten().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getInnenbereichEingangRechtsUnten() != null
							? blatt.getInnenbereichEingangRechtsUnten().getOpis()
							: "");

			row.createCell(j++)
					.setCellValue(blatt.getWeitereMessstellenHeizraum() != null
							? blatt.getWeitereMessstellenHeizraum().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getWeitereMessstellenWaschkuche() != null
							? blatt.getWeitereMessstellenWaschkuche().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getWeitereMessstellenAnderes1() != null
							? blatt.getWeitereMessstellen1() + ": " + blatt.getWeitereMessstellenAnderes1().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getWeitereMessstellenAnderes2() != null
							? blatt.getWeitereMessstellen2() + ": " + blatt.getWeitereMessstellenAnderes2().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getWeitereMessstellenAnderes3() != null
							? blatt.getWeitereMessstellen3() + ": " + blatt.getWeitereMessstellenAnderes3().getOpis()
							: "");
			row.createCell(j++)
					.setCellValue(blatt.getWeitereMessstellenAnderes4() != null
							? blatt.getWeitereMessstellen4() + ": " + blatt.getWeitereMessstellenAnderes4().getOpis()
							: "");

			row.createCell(j++).setCellValue(blatt.getMontageortDesGatewaysAdresse());
			row.createCell(j++).setCellValue(blatt.getMontageortDesGatewaysHausnummer());
			row.createCell(j++).setCellValue(blatt.getMontageortDesGatewaysRaumbezeichung());
			row.createCell(j++).setCellValue(blatt.isSteckdoseBereitsVorhanden() ? "JA" : "NEIN");
			row.createCell(j++).setCellValue(blatt.isBohrschabloneAngebract() ? "JA" : "NEIN");

		}

		for (int i = 0; i < columns.size(); i++) {
			blatt1.autoSizeColumn(i);
		}
		// -------------Blatt1----------------//

		// -------------Blatt2----------------//
		List<String> columnsBlatt2 = new ArrayList<>();
		columnsBlatt2.add("Auftragsnummer");
		columnsBlatt2.add("Lg-Nr. Gateway");
		columnsBlatt2.add("Montagedatum");
		columnsBlatt2.add("Servicepartner Nr");
		columnsBlatt2.add("PLZ");
		columnsBlatt2.add("Ort");
		columnsBlatt2.add("Strasse");

		columnsBlatt2.add("LFD");
		columnsBlatt2.add("MAC neu");
		columnsBlatt2.add("Abw. Anschrift Hauseingang");
		columnsBlatt2.add("Geschoss");
		columnsBlatt2.add("Lage");
		columnsBlatt2.add("Montage-position / Raum");
		columnsBlatt2.add("Montageart");
		columnsBlatt2.add("Power");
		columnsBlatt2.add("LoRa");
		columnsBlatt2.add("USB");
		columnsBlatt2.add("SAP-Nr");

		columnsBlatt2.add("Bemerkungen\nzur Montage");
		columnsBlatt2.add("Hybrid: Lcd Nr.\ndes Gateways");
		columnsBlatt2.add("Hybrid: Montageposition\nDer Antenn");
		columnsBlatt2.add("Hybrid: Sonstige\nBemerkung");

		Row headerRowBlatt2 = blatt2.createRow(0);
		headerRowBlatt2.setHeight((short)1000);

		for (int i = 0; i < columnsBlatt2.size(); i++) {
			Cell cell = headerRowBlatt2.createCell(i);
			cell.setCellValue(columnsBlatt2.get(i));
			cell.setCellStyle(headerCellStyle);
		}

		rowNum = 1;
		for (FormBlatt blatt : allBlatt) {
			int j = 0;
			Row row = blatt2.createRow(rowNum++);
			row.createCell(j++).setCellValue(blatt.getAuftragsNumer());
			row.createCell(j++).setCellValue(blatt.getLgNrGateway());
			row.createCell(j++).setCellValue (IspisBlatt.formatiranjeDatuma( new Date(IspisBlatt.formatiranjeStringLongDatum(blatt.getMontageDatum()))));
			row.createCell(j++).setCellValue(blatt.getServicePartnerNr());
			row.createCell(j++).setCellValue(blatt.getPlz());
			row.createCell(j++).setCellValue(blatt.getOrt());
			row.createCell(j++).setCellValue(blatt.getStrasse());
			row.createCell(18).setCellValue(blatt.getBemerkungenZurMontage());
			row.createCell(19).setCellValue(blatt.getBeiHybridInstallationLfdNrDesGateways());
			row.createCell(20).setCellValue(blatt.getBeiHybridInstallationLMontagepositionDerAntenne());
			row.createCell(21).setCellValue(blatt.getBeiHybridInstallationSonstigeBemerkung());
			Set<BlattLtdnr> ltdnrList = blatt.getLtdnr();
			if (ltdnrList.size() > 0) {
				int loop = 0;
				for (BlattLtdnr ltdNr : ltdnrList) {
					if (loop > 0) {
						row = blatt2.createRow(rowNum++);
						row.createCell(0).setCellValue(blatt.getAuftragsNumer());
						row.createCell(1).setCellValue(blatt.getLgNrGateway());
						row.createCell(2);
						row.getCell(2).setCellValue (IspisBlatt.formatiranjeDatuma( new Date(IspisBlatt.formatiranjeStringLongDatum(blatt.getMontageDatum()))));
						row.createCell(3).setCellValue(blatt.getServicePartnerNr());
						row.createCell(4).setCellValue(blatt.getPlz());
						row.createCell(5).setCellValue(blatt.getOrt());
						row.createCell(6).setCellValue(blatt.getStrasse());
						j = j - 11;
					}
					row.createCell(j++).setCellValue(ltdNr.getLtdnr());
					row.createCell(j++).setCellValue(ltdNr.getGatewayNummerNeu());
					row.createCell(j++).setCellValue(ltdNr.getAbwAnscriftHauseingang());
					row.createCell(j++)
							.setCellValue(ltdNr.getGeschloss() != null ? ltdNr.getGeschloss().getOpis() : "");
					row.createCell(j++).setCellValue(ltdNr.getLage() != null ? ltdNr.getLage().getOpis() : "");
					row.createCell(j++).setCellValue(
							ltdNr.getMontagePositionRaum() != null ? ltdNr.getMontagePositionRaum().getOpis() : "");
					row.createCell(j++)
							.setCellValue(ltdNr.getMontageort() != null ? ltdNr.getMontageort().getOpis() : "");
					row.createCell(j++).setCellValue(ltdNr.getPower() != null ? ltdNr.getPower().getOpis() : "");
					row.createCell(j++).setCellValue(ltdNr.getLora() != null ? ltdNr.getLora().getOpis() : "");
					row.createCell(j++).setCellValue(ltdNr.getUsb() != null ? ltdNr.getUsb().getOpis() : "");
					row.createCell(j++).setCellValue(ltdNr.getSapNr());
					loop++;

				}
			}
		}

		for (int i = 0; i < columns.size(); i++) {
			blatt2.autoSizeColumn(i);
		}
		// -------------Blatt2----------------//

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		excelIspis.write(bos);
		bos.close();
		byte[] bytes = bos.toByteArray();
		excelIspis.close();

		ByteArrayInputStream bisExcel = new ByteArrayInputStream(bytes);
		return new ByteArrayInputStream(bytes);
	}
	
}