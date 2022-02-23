package com.chaerin.s4.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	@Autowired
	private BankBookService bankBookService;
	
	//DB에 UPDATE를 처리하는 메소드
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO)throws Exception{
		int result =bankBookService.update(bankBookDTO);
		return "redirect:./list";
	}
	
	//update
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO=bankBookService.detail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
	}
	
	//delete
	@RequestMapping("delete")
	public String delete(BankBookDTO bankBookDTO) throws Exception{
		int result=bankBookService.delete(bankBookDTO);
		
		return "redirect:./list";
	}
	
		//detail
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(BankBookDTO bankBookDTO, Model model) throws Exception{
		bankBookDTO = bankBookService.detail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception{
		//ModelAndView
		//매개변수선언
		//메소드내에서객체생성
		//ModelAndView modelAndView = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.list();
		mv.addObject("list",ar);
		mv.setViewName("bankbook/list");
		return mv;
		
	}
	//DB에 insert
		@RequestMapping(value = "add", method=RequestMethod.POST)
		public String add(BankBookDTO bankBookDTO)throws Exception{
			int result = bankBookService.add(bankBookDTO);
			
			return "redirect:./list";
		}

	//insert form 이동
	   @RequestMapping(value="add",method=RequestMethod.GET)
	   public void add() throws Exception{
	      
	   }
	
}
