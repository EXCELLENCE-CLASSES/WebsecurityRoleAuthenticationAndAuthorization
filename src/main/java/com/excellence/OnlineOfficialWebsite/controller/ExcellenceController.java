package com.excellence.OnlineOfficialWebsite.controller;



import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.excellence.OnlineOfficialWebsite.model.ExcellenceClassesDetails;
import com.excellence.OnlineOfficialWebsite.model.ExcellenceDocument;
import com.excellence.OnlineOfficialWebsite.model.ExcellenceStudentDetails;
import com.excellence.OnlineOfficialWebsite.repository.ExcellenceClassesDetailsRepository;
import com.excellence.OnlineOfficialWebsite.repository.ExcellenceDocumentRepository;
import com.excellence.OnlineOfficialWebsite.repository.ExcellenceStudentDetailsRepository;
import com.excellence.OnlineOfficialWebsite.repository.ExcellenceTeacherDetailsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RestController
public class ExcellenceController {
	
	@Autowired
	private ExcellenceDocumentRepository repo;
	
	@Autowired
	ExcellenceClassesDetailsRepository excRepo ;
	
	@Autowired
	ExcellenceStudentDetailsRepository excStuRepo ;
	
	@Autowired
	ExcellenceTeacherDetailsRepository excTchRepo ;
	
	@PostMapping("/saveExcellence")
	public void saveExcellenceClasses(@RequestBody ExcellenceClassesDetails excServ )
	{
		System.out.println("hello");
		System.out.println(excServ);
		excRepo.save(excServ);
		
		
	}
	@RequestMapping("/abc")	
	public ModelAndView registrationPage(Model model) 
	{
		ExcellenceStudentDetails exc=new ExcellenceStudentDetails();
		model.addAttribute("abc", exc);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("registration.html");
		
		return mv;
	}
	
	@RequestMapping(value="register") 
	public ModelAndView registrationForm(@ModelAttribute("exc") ExcellenceStudentDetails exc) 
	{
		excStuRepo.save(exc);
		
		System.out.println(exc);
		  
		System.out.println("Executing here");
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.html");
		return mv ;		
		
		
	}
	
	@RequestMapping("contactUs")	
	public ModelAndView aboutUs(Model model) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("download.html");
		
		return mv;
	}
	
	
	@RequestMapping("aboutUs")	
	public ModelAndView contactUs(Model model) 
	{
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("aboutUs.html");
		
		return mv;
	}
	
	
	
	@GetMapping("/downloadg")		
	public ModelAndView myHomePage(Model model) 	
	{
		System.out.println("Here,Executing");
		List<ExcellenceDocument> excDoc=repo.findAll();
		model.addAttribute("exDoc", excDoc);
		System.out.println(excDoc);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("download.html");
		return mv ;
	}
	@PostMapping("/upload")
	public ModelAndView  uploadFile(@RequestParam("document") MultipartFile multipartFile, RedirectAttributes ra ) throws IOException 
	{
		String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
		ExcellenceDocument excDocument=new ExcellenceDocument();
		excDocument.setName(fileName);
		excDocument.setContent(multipartFile.getBytes());
		excDocument.setSize(multipartFile.getSize());
		excDocument.setUploadTime(new Date());
		repo.save(excDocument);
		ra.addFlashAttribute("message", "WOW!The File has been uploaded successfully ");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/downloadg");
		return mv ;
		
		
		//return "redirect:/downloadg";
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
