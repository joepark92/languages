package com.joepark.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joepark.languages.models.Lang;
import com.joepark.languages.services.LangService;

@Controller
public class LangController {
	
	private final LangService langService;

    public LangController(LangService langService){
        this.langService = langService;
    }
    
	@RequestMapping("/")
	public String sendToIndex() {
		return "redirect:/languages";
	}
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Lang lang) {
		List<Lang> langs = langService.allLangs();
		model.addAttribute("langs", langs);
		return "index.jsp";
	}
	@PostMapping("/languages")
	public String createLang(@Valid @ModelAttribute("language") Lang lang, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/languages";
		} else {
			langService.createLang(lang);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/languages/{id}")
	public String getLang(Model model, @PathVariable("id") Long id) {
		Lang lang = langService.findLang(id);
		if(lang == null) {
			return "redirect:/languages";
		}
		model.addAttribute("lang", lang);
		return "view.jsp";
	}
	@RequestMapping("/languages/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id, @ModelAttribute("language") Lang lang) {
		Lang getlang = langService.findLang(id);
		if(getlang == null) {
			return "redirect:/languages";
		}
		model.addAttribute("lang", getlang);
		return "edit.jsp";
	}
	@PostMapping("/languages/edit/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Lang lang, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/languages/edit/"+id;
		}
		langService.update(lang);
		return "redirect:/languages/"+id;
	}
	@RequestMapping("/languages/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		langService.deleteLang(id);
		return "redirect:/languages";
	}
}