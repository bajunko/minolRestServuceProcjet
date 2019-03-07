package de.minol.gatways.rest.spring.boot.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.minol.gatways.rest.spring.boot.model.BlattZweiLtdnr;
import de.minol.gatways.rest.spring.boot.model.FormBlatt;
import de.minol.gatways.rest.spring.boot.model.FormBlattEins;
import de.minol.gatways.rest.spring.boot.model.FormBlattZwei;
import de.minol.gatways.rest.spring.boot.pdf.ExcelGenerator;
import de.minol.gatways.rest.spring.boot.pdf.ReportFactory;
import de.minol.gatways.rest.spring.boot.repository.FormBlattEinsRepository;
import de.minol.gatways.rest.spring.boot.repository.FormBlattRepository;
import de.minol.gatways.rest.spring.boot.repository.FormBlattZweiRepository;
import de.minol.gatways.rest.spring.boot.service.BlattService;

@RestController
public class BlattController {
	
	@Autowired
	FormBlattEinsRepository formBlattEinsRepository;
	@Autowired
	FormBlattZweiRepository formBlattZweiRepository;
	@Autowired
	FormBlattRepository formBlattRepository;
	@Autowired
	BlattService blattService;
	@Autowired
	ReportFactory reportFactorry;
	
	@RequestMapping("/")
	public String healthCheck()	{
		return "REST radi ok - verzija PDF - dodatk hinweis verzija prod";
	}
	
	@GetMapping("/blattEins")
	public List<FormBlattEins> allBlattEins(){
		return (List<FormBlattEins>) formBlattEinsRepository.findAll();
	}
	
	@GetMapping("/blattEins/{id}")
	public FormBlattEins blattEinsbyId(@PathVariable long id){
		return  formBlattEinsRepository.findOne(id);
	}

	@RequestMapping(value = "/neuBlattEins", method = RequestMethod.POST)
	public int insertBlattEins(@RequestBody FormBlattEins blattEins) throws IOException {
//		ClassPathResource backImgFile = new ClassPathResource("image/comprapair.jpg");
//		byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
//		backImgFile.getInputStream().read(arrayPic);
//		blattEins.setPic(arrayPic);
	//	ImageModel blackImage = new ImageModel(1, "JSA-ABOUT-IMAGE-BLACK-BACKGROUND", "png", arrayPic);
		return blattService.addBlattEins(blattEins) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}
	
	
	
	
	@GetMapping("/blattZwei")
	public List<FormBlattZwei> allBlattZwei(){
		return (List<FormBlattZwei>) formBlattZweiRepository.findAll();
	}
	
	@GetMapping("/blattZwei/{id}")
	public FormBlattZwei blattZweibyId(@PathVariable long id){
		return  formBlattZweiRepository.findOne(id);
	}

	

	@RequestMapping(value = "/neuBlattZwei", method = RequestMethod.POST)
	public int insertBlattZwei(@RequestBody FormBlattZwei blattZwei) {
		return blattService.addBlattZwei(blattZwei) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}	
	
	
	@RequestMapping(value = "/neuBlattZweiLtdnr", method = RequestMethod.POST)
	public int insertBlattZweiLtdnr(@RequestBody BlattZweiLtdnr blattZweiLtdnr) {
		return blattService.addBlattZweiLtdr(blattZweiLtdnr) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}	

	@DeleteMapping(value = "/deleteBlattEins/{id}" )
	public void deleteBlattEins(@PathVariable long id ) {
		formBlattEinsRepository.delete(id);
	}

	@DeleteMapping(value = "/deleteBlattZwei/{id}" )
	public void deleteBlattZwei(@PathVariable long id ) {
		formBlattZweiRepository.delete(id);
	}
	
	@GetMapping(value = "/download/customers.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<FormBlattEins> customers = (List<FormBlattEins>) formBlattEinsRepository.findAll();
		
		ByteArrayInputStream in = ExcelGenerator.customersToExcel(customers);
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
		
		 return ResponseEntity
	                .ok()
	                .headers(headers)
	                .body(new InputStreamResource(in));
    }
	
	
	
	
//	@GetMapping(value = "/api/pdf",
//            produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> customersReport() throws IOException {
//        List<FormBlattEins> customers = (List<FormBlattEins>) formBlattEinsRepository.findAll();
// 
//        List<FormBlattEins> einsList = new ArrayList<>();
//     //   einsList.add(eins);
//        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(customers);
// 
//        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=blatt.pdf");
// 
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
	
//	@GetMapping(value = "/api/pdf",
//            produces = MediaType.APPLICATION_PDF_VALUE)
//    public ByteArrayInputStream customersReport() throws IOException {
//        List<FormBlattEins> customers = (List<FormBlattEins>) formBlattEinsRepository.findAll();
// 
//        List<FormBlattEins> einsList = new ArrayList<>();
//     //   einsList.add(eins);
//        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(customers);
//        
//        return bis;
// 
// 
//        
//    }
	
	
//	@RequestMapping(value = "/image-manual-response", method = RequestMethod.GET)
//	public void getImageAsByteArray(HttpServletResponse response) throws IOException {
//		FormBlattEins blattEinsbyId = blattEinsbyId(2);
//	    InputStream in = blattEinsbyId.getPic();
//	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//	    IOUtils.copy(in, response.getOutputStream());
//	}
	
	@GetMapping(value = "/image")
    public ResponseEntity<InputStreamResource> imageDownload() throws IOException {
 
		FormBlattEins blattEinsbyId = blattEinsbyId(3);
		ByteArrayInputStream bis = new ByteArrayInputStream( blattEinsbyId.getPic());
 
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=image.png");
 
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(bis));
    }
	

	// Ispod su REST za spojen modele Blatt1 i Blatt2:
	
	@RequestMapping(value = "/neuBlatt", method = RequestMethod.POST)
	public int insertBlatt(@RequestBody FormBlatt blatt) throws IOException {
//		ClassPathResource backImgFile = new ClassPathResource("image/comprapair.jpg");
//		byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
//		backImgFile.getInputStream().read(arrayPic);
//		blattEins.setPic(arrayPic);
	//	ImageModel blackImage = new ImageModel(1, "JSA-ABOUT-IMAGE-BLACK-BACKGROUND", "png", arrayPic);
		return blattService.addBlatt(blatt) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}
	
	@RequestMapping(value = "/neuBlattPdf", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> insertBlattPdf(@RequestBody FormBlatt blatt) {
		
		blattService.addBlatt(blatt);
		
		try {
			return blattReportJasper(blatt);
		} catch (IOException e) {
			System.out.println("Gresko prilikom gereranja pdf");
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	@GetMapping("/blatt")
	public List<FormBlatt> allBlatt(){
		return (List<FormBlatt>) formBlattRepository.findAll();
	}
	
	@GetMapping("/blatt/{id}")
	public FormBlatt blattbyId(@PathVariable long id){
		return  formBlattRepository.findOne(id);
	}
	
	@DeleteMapping(value = "/deleteBlatt/{id}" )
	public void deleteBlatt(@PathVariable long id ) {
		formBlattRepository.delete(id);
	}
	
	
	
	
	//Primjer sa Jasper Reportom
	@GetMapping(value = "blattjasperpdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> blattReportJasper(FormBlatt eins) throws IOException {
//         FormBlatt findOne = formBlattRepository.findOne(new Long(102));
 
        
        
        byte[] printReport = reportFactorry.printReport(eins);
        
        
        
        ByteArrayInputStream bisJasper = new ByteArrayInputStream(printReport);
        Long timestamp = new Date().getTime();
        String nazivFilla = "Blatt_" + timestamp.toString();
 
       // spremiPdfNaServer(printReport, nazivFilla);
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("Content-Disposition", "inline; filename="+ nazivFilla + ".pdf");
 
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bisJasper));
    }
	
	private void spremiPdfNaServer(byte[] pdf, String naziv) {
		
		File filePdf = new File("root/Minol/" + naziv +".pdf");
		try {
			FileUtils.writeByteArrayToFile(filePdf, pdf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//Primjer sa Jasper Reportom
	@GetMapping(value = "blattjasperexcel")
	public ResponseEntity<InputStreamResource> blattReportJasperExcel(FormBlatt eins) throws IOException {
		
		Long timestamp = new Date().getTime();
		String nazivFilla = "Export_" + timestamp.toString();
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.add("Content-Disposition", "inline; filename="+ nazivFilla + ".xlsx");
		
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(new InputStreamResource(ExcelGenerator.generateExcelReport(allBlatt())));
	}

	public ReportFactory getReportFactorry() {
		return reportFactorry;
	}

	public void setReportFactorry(ReportFactory reportFactorry) {
		this.reportFactorry = reportFactorry;
	}
	

}
