package space.bum.zip_search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import space.bum.zip_search.domain.SearchKey;

@Controller
public class SearchController {
  @GetMapping("/searchForm")
  public String addressSearchForm(Model model) {
    model.addAttribute("searchKey", new SearchKey());
    return "searchform";
  }
  
  @PostMapping("/searchAddress")
  public String addressSearchForm(@Valid SearchKey searchKey,
      BindingResult result, Model model) {
    System.out.println("주소 검색어: " + searchKey.getAddrKey());
    return "searchform";
  }
}
