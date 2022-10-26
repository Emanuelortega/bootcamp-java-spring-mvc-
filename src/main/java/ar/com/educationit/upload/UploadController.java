package ar.com.educationit.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

	//establezco un Logger para esta clase 
	 final static Logger logger = LoggerFactory.getLogger(UploadController.class);

	 //establezco la url= http://localhost:8081/upload
	@GetMapping(value ="/upload")
	public String index() {
		return "/file/index";
	}
	
	//recibo el archivo enviadp
	@PostMapping(value ="/file")
	public String file(
			@RequestParam("file")  MultipartFile file, RedirectAttributes redirect) {
		
		//Obtengo y guardo el nombre y tamaño del archivo enviado
		String fileName = file.getOriginalFilename();
		Long fileSize = file.getSize();
		
		//valido que el archivo sea "txt" o "csv"
		if(validar(fileName)) {
			
			//establezco un msj de exito y una clase de bootstrap
			redirect.addFlashAttribute("msj", "Archivo cargado exitosamente")
			.addFlashAttribute("class", "alert-success");
			
			//imprimo el Nombre y Tamaño del file en el archivo de Logs
			logger.info("Nombre del file ingresado: " + fileName);
			logger.info("Tamaño del file ingresado: " + fileSize.toString()+ " bytes");
			
		}else {
			//establezco un msj de error y una clase de bootstrap
			redirect.addFlashAttribute("msj", "Archivo incompatible")
			.addFlashAttribute("class", "alert-danger");
			
			//imprimo el Nombre  del file en el archivo de Logs
			logger.error("Archivo incompatible: "+ fileName);
		}
		
		return "redirect:/upload";
	}

	//validacion del archivo
	private boolean validar(String fileName) {
		
		boolean valor = false;
		String [] name = fileName.split("\\.");
		String ext = name[name.length-1];
		if(ext.equalsIgnoreCase("csv") || ext .equalsIgnoreCase("txt")) {
		 valor = true;
		}
		return valor;
	}
		
}
