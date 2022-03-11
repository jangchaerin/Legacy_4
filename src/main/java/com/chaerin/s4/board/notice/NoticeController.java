package com.chaerin.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chaerin.s4.board.BoardDTO;
import com.chaerin.s4.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}
	
	//detail
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception{
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception{
		
		List<BoardDTO> ar = noticeService.list(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
	}
	
	//DB에 insert
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, MultipartFile [] files) throws Exception{
		int result = noticeService.add(noticeDTO,files);
		return "redirect:./list";
	}
	//insert form이동
	@RequestMapping(value="add", method=RequestMethod.GET)
	public ModelAndView add() throws Exception{
		ModelAndView mv=new ModelAndView();
	
		mv.setViewName("board/add");
		return mv;
	}
	
	@RequestMapping("delete")
	   public String delete(NoticeDTO noticeDTO) throws Exception{
	      int result = noticeService.delete(noticeDTO);
	         return "redirect:./list";
	      }

	
	@RequestMapping(value="update",method=RequestMethod.GET)
	   public String update(NoticeDTO noticeDTO,Model model)throws Exception{
	      BoardDTO boardDTO = noticeService.detail(noticeDTO);
	      model.addAttribute("dto",boardDTO);
	      return "board/update";
	   }
	   
	   @RequestMapping(value="update",method=RequestMethod.POST)
	   public ModelAndView update(NoticeDTO noticeDTO)throws Exception{
	      ModelAndView mv= new ModelAndView();
	      int result =noticeService.update(noticeDTO);
	      mv.setViewName("redirect:./list");
	      return mv;
	   }
	   
	
	
		

}