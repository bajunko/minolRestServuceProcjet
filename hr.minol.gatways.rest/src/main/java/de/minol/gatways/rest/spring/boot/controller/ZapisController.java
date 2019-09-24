package de.minol.gatways.rest.spring.boot.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.minol.gatways.rest.spring.boot.model.Users;
import de.minol.gatways.rest.spring.boot.model.Zapis;
import de.minol.gatways.rest.spring.boot.repository.UsersRepository;
import de.minol.gatways.rest.spring.boot.repository.ZapisRepository;
import de.minol.gatways.rest.spring.boot.service.ZapisService;

@RestController
public class ZapisController {
	
	SimpleDateFormat sdfTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
	
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	ZapisRepository zapisRepository;
	@Autowired
	ZapisService zapisService;
	
	
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

	@RequestMapping(value = "/unosNovogZapisa", method = RequestMethod.POST)
	public int insertZapis(@RequestBody Zapis zapis) throws IOException {
//		ClassPathResource backImgFile = new ClassPathResource("image/comprapair.jpg");
//		byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
//		backImgFile.getInputStream().read(arrayPic);
//		blattEins.setPic(arrayPic);
	//	ImageModel blackImage = new ImageModel(1, "JSA-ABOUT-IMAGE-BLACK-BACKGROUND", "png", arrayPic);
		return zapisService.addZapis(zapis) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}
	
	
	
	
	
	

	@DeleteMapping(value = "/brisanjeZapisa/{id}" )
	public void deleteBlattEins(@PathVariable long id ) {
		zapisRepository.delete(id);
	}

	

}
