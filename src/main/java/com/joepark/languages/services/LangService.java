package com.joepark.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.joepark.languages.models.Lang;
import com.joepark.languages.repositories.LangRepository;

@Service
public class LangService {
    // adding the book repository as a dependency
    private final LangRepository langRepository;
    
    public LangService(LangRepository langRepository) {
        this.langRepository = langRepository;
    }
    // returns all the books
    public List<Lang> allLangs() {
        return langRepository.findAll();
    }
    // creates a book
    public Lang createLang(Lang x) {
        return langRepository.save(x);
    }
    // retrieves a book
    public Lang findLang(Long id) {
        Optional<Lang> optionalLang = langRepository.findById(id);
        if(optionalLang.isPresent()) {
            return optionalLang.get();
        } else {
            return null;
        }
    }

	public void deleteLang(Long id) {
		langRepository.deleteById(id);
		
	}
	public Lang update(Lang lang) {
		return langRepository.save(lang);
	}
}