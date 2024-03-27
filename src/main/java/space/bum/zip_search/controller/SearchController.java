package space.bum.zip_search.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import space.bum.zip_search.domain.FoundAddress;
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
    var addresses = new ArrayList<FoundAddress>();    
    
    createDummyAddresses(addresses);
    model.addAttribute("addresses", addresses);
    System.out.println("검색 건수: " + addresses.size());    
    return "searchform";
  }
  
  private void createDummyAddresses(ArrayList<FoundAddress> addresses) {
    addresses.add(new FoundAddress("12345", "서울시 종로구 관철동 134번지"));
    addresses.add(new FoundAddress("23233", "경기도 하남시 망월동 1050번지"));
  }
}
