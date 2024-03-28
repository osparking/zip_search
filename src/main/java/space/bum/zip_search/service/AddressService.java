package space.bum.zip_search.service;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import space.bum.zip_search.domain.FoundAddress;

@Service
public class AddressService {
  final private List<FoundAddress> addresses = AddressUtils.buildAddresses();
  
  public Page<FoundAddress> findPaginated(Pageable pageable) {
    int pageSize = pageable.getPageSize();
    int currentPage = pageable.getPageNumber();
    int startItem = currentPage * pageSize;
    List<FoundAddress> list;

    if (addresses.size() < startItem) {
      list = Collections.emptyList();
    } else {
      int toIndex = Math.min(startItem + pageSize, addresses.size());
      list = addresses.subList(startItem, toIndex);
    }

    Page<FoundAddress> addressPage = new PageImpl<FoundAddress>(list,
        PageRequest.of(currentPage, pageSize), addresses.size());

    return addressPage;
  }  
}
