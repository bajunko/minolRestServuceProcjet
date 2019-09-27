package de.minol.gatways.rest.spring.boot.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import de.minol.gatways.rest.spring.boot.model.FileUploadMetaData;
import de.minol.gatways.rest.spring.boot.model.Folder;
import de.minol.gatways.rest.spring.boot.model.Users;
import de.minol.gatways.rest.spring.boot.model.Zapis;
import de.minol.gatways.rest.spring.boot.repository.FileUploadRepository;
import de.minol.gatways.rest.spring.boot.repository.FolderRepository;
import de.minol.gatways.rest.spring.boot.repository.UsersRepository;
import de.minol.gatways.rest.spring.boot.repository.ZapisRepository;
import de.minol.gatways.rest.spring.boot.service.ZapisService;

@RestController
public class FolderController {
	
//	private static String UPLOADED_FOLDER = "c:\\Users\\Ante\\Razvoj\\Java\\RestMultipart\\git_h2\\Spring-Boot-FIle-Upload-Rest-Service\\";
	private static String UPLOADED_FOLDER = "/var/www/html/restapi/";
	private final Logger logger = LoggerFactory.getLogger(FolderController.class);
	SimpleDateFormat sdfTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
	
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	ZapisRepository zapisRepository;
	@Autowired
	ZapisService zapisService;
	@Autowired
	private FileUploadRepository fileUploadMetaData;
	@Autowired
	FolderRepository folderRepository;
	
	
	@RequestMapping("/")
	public String healthCheck()	{
		return "REST API radi ok ";
	}
	
	@GetMapping("/blattUsers")
	public List<Users> allZapisUsers(){
		return (List<Users>) usersRepository.findAll();
	}
	
//	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
//	public int insertUser(@RequestBody Users user) {
//		return blattService.addUsers(user) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
//	}	
	
	@GetMapping("/sviZapisi")
	public List<Zapis> allBlattEins(){
		return (List<Zapis>) zapisRepository.findAll();
	}
	
	@GetMapping("/zapis/{id}")
	public Zapis zapisById(@PathVariable long id){
		return  zapisRepository.findOne(id);
	}

	@RequestMapping(value = "/unosNovogFoldera", method = RequestMethod.POST)
	public int insertZapis(@RequestBody Folder folder) throws IOException {
//		ClassPathResource backImgFile = new ClassPathResource("image/comprapair.jpg");
//		byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
//		backImgFile.getInputStream().read(arrayPic);
//		blattEins.setPic(arrayPic);
	//	ImageModel blackImage = new ImageModel(1, "JSA-ABOUT-IMAGE-BLACK-BACKGROUND", "png", arrayPic);
		
		
		boolean mkdirs;
		mkdirs = new File(UPLOADED_FOLDER + folder.getNaziv()).mkdirs();
		
		
		return zapisService.addFolder(folder) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}
	
	@GetMapping("/folder/{name}")
	public int folderByName(@PathVariable String name){
		
		 Iterable<Folder> findAll = folderRepository.findAll();
		 
		 for (Iterator<Folder> iterator = findAll.iterator(); iterator.hasNext();) {
			Folder folder = iterator.next();
			if(folder.getNaziv().contains(name)) {
				return (int)folder.getId();
			}
			
		}
		 
		 return 0;
		
	}
	
	
	
	
	
	

	@DeleteMapping(value = "/brisanjeZapisa/{id}" )
	public void deleteBlattEins(@PathVariable long id ) {
		zapisRepository.delete(id);
	}

	
	// Za upload Multipartfile-a
	/**
	 * Single file upload
	 * @param uploadfile
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/api/fileupload", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile,
			@RequestParam("path") String putanja,
			final HttpServletRequest request) {

		/** Below data is what we saving into database */
		logger.debug("Single file upload!");
		logger.debug("fileName : " + uploadfile.getOriginalFilename());
		logger.debug("contentType : " + uploadfile.getContentType());
		logger.debug("contentSize : " + uploadfile.getSize());

		if (uploadfile.isEmpty()) {
			return new ResponseEntity<String>("please select a file!", org.springframework.http.HttpStatus.OK);
		}

		try {
			/** File will get saved to file system and database */
			saveUploadedFiles(Arrays.asList(uploadfile), putanja);
		} catch (IOException e) {
			return new ResponseEntity<>(org.springframework.http.HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successfully uploaded - " + uploadfile.getOriginalFilename(),
				new HttpHeaders(), org.springframework.http.HttpStatus.OK);

	}
	
	
	
	
	
	
	/**
	 * Single file upload
	 * @param uploadfile, idFolera
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/api/fileuploadid", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFileInFolderid(@RequestParam("file") MultipartFile uploadfile,
			@RequestParam("folderId") String folderIdString,
			final HttpServletRequest request) {
		
		long folderId = Long.parseLong(folderIdString);
		//Dohvati naziv folder od id-a
		Folder folder = folderRepository.findOne((Long)folderId);
		String putanja = folder.getNaziv() + "/";

		/** Below data is what we saving into database */
		logger.debug("Single file upload!");
		logger.debug("fileName : " + uploadfile.getOriginalFilename());
		logger.debug("contentType : " + uploadfile.getContentType());
		logger.debug("contentSize : " + uploadfile.getSize());

		if (uploadfile.isEmpty()) {
			return new ResponseEntity<String>("please select a file!", org.springframework.http.HttpStatus.OK);
		}

		try {
			/** File will get saved to file system and database */
			saveUploadedFiles(Arrays.asList(uploadfile), putanja);
		} catch (IOException e) {
			return new ResponseEntity<>(org.springframework.http.HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successfully uploaded - " + uploadfile.getOriginalFilename(),
				new HttpHeaders(), org.springframework.http.HttpStatus.OK);

	}
	
	
	
	

	/**
	 * Multiple files to upload
	 * @param extraField
	 * @param uploadfiles
	 * @return
	 */
	@RequestMapping(value = "/api/upload/multiplefiles", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFileMulti(@RequestParam("files") MultipartFile[] uploadfiles, 
			@RequestParam("path") String putanja) {
		logger.debug("Multiple file upload!");
		String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
				.filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
		if (StringUtils.isEmpty(uploadedFileName)) {
			return new ResponseEntity<String>("please select files!", org.springframework.http.HttpStatus.OK);
		}
		
		if (uploadfiles.length==0) {
			return new ResponseEntity<String>("please select files!", org.springframework.http.HttpStatus.OK);
		}
		
		try {
			/** File will get saved to file system and database */
			saveUploadedFiles(Arrays.asList(uploadfiles), putanja);
		} catch (IOException e) {
			return new ResponseEntity<>(org.springframework.http.HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Successfully uploaded - " + uploadedFileName, org.springframework.http.HttpStatus.OK);

	}

	/**
	 * Rest endpoint api to get uploaded files 
	 * @return
	 */
	@RequestMapping(value = "/getFileUploadMetaData", method = RequestMethod.GET)
	public List<FileUploadMetaData> fileUploadMetaData() {
		List<FileUploadMetaData> fileMetaData = fileUploadMetaData.findAll();
		return fileMetaData;
	}

	/**
	 * Files will get saved to file system and database
	 * @param files
	 * @throws IOException
	 */
	private void saveUploadedFiles(List<MultipartFile> files, String putanja) throws IOException {
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue; 
			}
			
		    String put = UPLOADED_FOLDER + putanja;
			byte[] bytes = file.getBytes();
			//Za windows
//			Path path = Paths.get(put + "\\" +file.getOriginalFilename());
			//Za linux
			Path path = Paths.get(put  +file.getOriginalFilename());
			Files.write(path, bytes);
			saveMetaData(file);

		}

	}

	/**
	 * Saves meta data to database
	 * @param file
	 * @throws IOException
	 */
	private void saveMetaData(MultipartFile file) throws IOException {
		FileUploadMetaData metaData = new FileUploadMetaData();
		metaData.setName(file.getOriginalFilename());
		metaData.setContentType(file.getContentType());
		metaData.setContentSize(file.getSize());
		fileUploadMetaData.save(metaData);
	}
	
	@GetMapping("/sviFileovi")
	public List<FileUploadMetaData> allFiles(){
		return (List<FileUploadMetaData>) fileUploadMetaData.findAll();
	}

}
