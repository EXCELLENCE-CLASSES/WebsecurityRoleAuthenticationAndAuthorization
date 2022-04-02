package com.example.demo;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class DMController {
	
	
	@Autowired
	private ExcellenceDocumentRepository repo;
	
	@GetMapping("/")	
	public String myHomePage(Model model) 	
	{
		List<ExcellenceDocument> excDoc=repo.findAll();
		model.addAttribute("exDoc", excDoc);
		return "index.html";
	}
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("document") MultipartFile multipartFile, RedirectAttributes ra ) throws IOException 
	{
		String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
		ExcellenceDocument excDocument=new ExcellenceDocument();
		excDocument.setName(fileName);
		excDocument.setContent(multipartFile.getBytes());
		excDocument.setSize(multipartFile.getSize());
		excDocument.setUploadTime(new Date());
		repo.save(excDocument);
		ra.addFlashAttribute("message", "WOW!The File has been uploaded successfully ");
		
		
		return "redirect:/";
	}
	@GetMapping("/download")
     public void downloadFile(@Param("id") Long id ,HttpServletResponse response) throws Exception 
	{
		Optional<ExcellenceDocument> result=repo.findById(id);
		if(!result.isPresent()) 
		{
			throw new  Exception("Could not find document with ID:"+id);
			
		}
		ExcellenceDocument excDoc=result.get();
		response.setContentType("application/octet-stream");
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename="+excDoc.getName();
		response.setHeader(headerKey, headerValue);
		ServletOutputStream outputStream=response.getOutputStream();
		
		outputStream.write(excDoc.getContent());
		outputStream.close();
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
