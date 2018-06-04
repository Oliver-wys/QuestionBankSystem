package qbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/user")
public class TestPaperViewController {

	@RequestMapping(method = RequestMethod.GET, value = "/testpaper")
	public String allTestInf() {
		return "testpaper";
	}
}
