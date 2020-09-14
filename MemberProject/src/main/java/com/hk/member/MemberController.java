package com.hk.member;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hk.member.service.MemberService;
import com.hk.member.vo.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	MemberService memberService;

	@Autowired
	ServletContext sc;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	@GetMapping("/member/list")
	public String memberList(Locale locale, Model model) {
		//콘트롤러 역할
		//1. URL 설정(@RequestMapping, @getMapping=RequestMethod.GET)
		//2. DB관련 작업
		//		-Service
		//		-Repository
		//3.비지니스 로직(덧셈,뺄셈 등등 뭐든지~)
		//4.사용자가 입력한 정보(Request.getParameter("name"))
		//5.보관소에 값 저장(sc,session,request->model)
		//6.JSP호출 "memberList-->메소드 명하고 일치" ->규칙은 WEB-INF/spring/appServlet/servlet-context.xml
		
		logger.info("Welcome home! The client locale is {}.", locale);
	
		model.addAttribute("members", memberService.memberList());
		
		return "memberList";
	}
	
	 @RequestMapping(value = "/upload", method = RequestMethod.POST , headers = "content-type=multipart/*")
	   //@PostMapping("/upload")
	   public String upload(@RequestParam("file") MultipartFile multipartFile,Model model) {
	      logger.info("### upload");
	      logger.info("실제 파일이름은 ? " + multipartFile.getOriginalFilename());
	      File targetFile = new File(sc.getRealPath("/resources/fileupload/") + multipartFile.getOriginalFilename());
	      logger.info("파일 저장위치는 :  " + targetFile);
	      try {
	         InputStream fileStream = multipartFile.getInputStream();
	         FileUtils.copyInputStreamToFile(fileStream, targetFile);
	      } catch (IOException e) {
	         FileUtils.deleteQuietly(targetFile);
	         e.printStackTrace();
	      }
	      
	      // 실제 디렉토리와 URL은 다르다.. 
	      // URL은 http://localhost:9999/resources/fileupload/실제파일명
	      // model에 담아서 jsp에서 img로 출력 
	      
	      model.addAttribute("imgSrc", "/resources/fileupload/" + multipartFile.getOriginalFilename());
	      return "upload";
	   }
	   
	@GetMapping("/member/register")
	public String memberRegisterGet(Model model) {
		logger.info("/member/register 호출");
		return "memberRegister";
		
	}
	
	 @PostMapping("/member/register")
	   public String memberRegisterPost(Model model, Member member) {
	      // 사용자가 입력한 값을 가져온다.. 
	      // 1) request.getParameter -- 예전 servlet 방식
	      // 2) @RequestParam을 이용하여 가져온다. - servlet방식과 동일
	      // 3) DTO를 선언한다. Client에 있는 html name 값이 DTO와 동일하면 
	      //    spring에서 알아서 넣어준다.
	      logger.info("/member/registerPost 호출");
	      
	      logger.info("사용자에게 입력받은 값 = " + member.toString());
	      int retVal = memberService.memberRegister(member);
	      logger.info("insert 후에 성공인지 실패인지 알려줌.. ["+retVal +"]");
	      return "memberRegisterPost";
	   }
	
	 @GetMapping("/member/update")
	 public String memberUpdateGet(@RequestParam("mno")int mno,Model model) {
		 logger.info("/member/memberUpdateGet 호출");
		 
		 logger.info("사용자에게 입력받은 값="+mno);
		 model.addAttribute("member",memberService.memberGetOne(mno));
		 return "memberUpdateGet";
	 }
	 @PostMapping("/member/update")
	 public String memberUpdatePost(Member member,Model model) {
		 logger.info("/member/memberUpdatePost 호출");
		 
		 logger.info("사용자에게 입력받은 값="+member.toString());
		 memberService.memberUpdate(member);
		 model.addAttribute("member",member);
		 return "memberUpdatePost";
	 }
	 
	 @GetMapping("/member/delete")
	 public String memberDeleteGet(@RequestParam("mno")int mno,Model model,Member member) {
		 model.addAttribute("member",memberService.memberGetOne(mno));
		 return "memberDeleteGet";
	 }
	 
	 @PostMapping("/member/delete")
	 public String memberDeletePost(@RequestParam("mno")int mno) {
		 
		 memberService.memberDelete(mno);
		 return "memberDeletePost";
	 }
	 
	 @GetMapping("/auth/login")
	 public String memberLogin(Model model) {
		 return "memberLogin";
	 }
	 
	 @PostMapping("/auth/login")
	 public String memberLoginPost(Member member,HttpSession httpSession) {
		 Member loginMember =memberService.memberLogin(member);
		 boolean login=loginMember!=null;
		 if(login) {
			 httpSession.setAttribute("loginMember", loginMember);
			 return "redirect:/member/list";
		 } else {
			 return "loginFail";
		 }
	 }
	 
	 @GetMapping("/auth/logout")
	 public String memberLogout(HttpSession httpSession) {
		 httpSession.invalidate();
		 return "redirect:/member/list";
	 }
	 
	 
	 
}
