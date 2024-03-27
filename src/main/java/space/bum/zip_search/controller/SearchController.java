package space.bum.zip_search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import space.bum.zip_search.domain.SearchKey;

@Controller
public class SearchController {
  @GetMapping("/searchForm")
  public String addressSearchForm(Model model) {
    model.addAttribute("searchKey", new SearchKey());
    return "searchform";
  }

}
