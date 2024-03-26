package space.bum.zip_search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
  @GetMapping("/search")
  public String addressSearchForm() {
    return "searchform";
  }
}
