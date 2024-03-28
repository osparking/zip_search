package space.bum.zip_search.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import space.bum.zip_search.domain.FoundAddress;
import space.bum.zip_search.domain.SearchKey;
import space.bum.zip_search.service.AddressService;

@Controller
public class SearchController {
  @GetMapping("/searchform")
  public String addressSearchForm(Model model) {
    model.addAttribute("searchKey", new SearchKey());
    return "searchform";
  }

  @Autowired
  private AddressService addressService;
  
  @GetMapping("/searchAddress")
  public String addressSearchForm(@Valid SearchKey searchKey,
      BindingResult result, Model model,
      @RequestParam("page") Optional<Integer> page,
      @RequestParam("size") Optional<Integer> size) {
    int currentPage = page.orElse(1);
    int pageSize = size.orElse(5);
    Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
    Page<FoundAddress> addressPage = addressService.findPaginated(pageable);
    long total = addressPage.getTotalElements();
    model.addAttribute("addressPage", addressPage);
    model.addAttribute("currentPage", addressPage.getNumber() + 1);
    
    int totalPages = addressPage.getTotalPages();
    
    model.addAttribute("totalPages", totalPages);
    if (totalPages > 0) {
      List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
          .boxed()
          .collect(Collectors.toList());
      model.addAttribute("pageNumbers", pageNumbers);
    }
    return "searchform";
  }
}
