package space.bum.zip_search.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import space.bum.zip_search.controller.ZipcodeUtil;
import space.bum.zip_search.domain.FoundAddress;
import space.bum.zip_search.domain.SearchKey;

@Service
public class ZipcodeService {

  public Page<FoundAddress> findPaginated(@Valid SearchKey searchKey,
      Pageable pageable) {
    int pageSize = pageable.getPageSize();
    int currentPage = pageable.getPageNumber();
    List<FoundAddress> pageAddresses = new ArrayList<FoundAddress>();
    int[] result = new int[2];
    
    ZipcodeUtil.find(searchKey.getAddrKey(), currentPage + 1, pageSize,
        pageAddresses, result);
    Page<FoundAddress> addressPage = new PageImpl<FoundAddress>(pageAddresses,
        PageRequest.of(currentPage, pageSize), result[0]);

    return addressPage;
  }
}
