package net.skhu.repository;

import net.skhu.domain.Customers;
import net.skhu.domain.Orders;
import net.skhu.model.Option;
import net.skhu.model.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    Option[] orderBy = { new Option(0, "id 순서"), new Option(1, "직위 순"), new Option(2, "도시순") };
    Option[] searchBy = { new Option(0, "검색 없음"), new Option(1, "고객 이름"), new Option(2, "직위") ,
            new Option(3, "도시")};

    Sort[] sort = { new Sort(Sort.Direction.ASC, "id"),
            new Sort(Sort.Direction.ASC, "jobTitle"),
            new Sort(Sort.Direction.ASC, "city") };

    public default List<Customers> findAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);

        Page<Customers> page = null;
        String searchText = pagination.getSt();
        switch (pagination.getSb()) {

            case 1:
                page = this.findByLastNameOrFirstName(searchText, searchText,pageable);
                break;

            case 2:
                page = this.findByJobTitleContaining(searchText, pageable);
                break;

            case 3:
                page = this.findByCityStartingWith(searchText, pageable);
                break;
            default:
                page = this.findAll(pageable);
                break;
        }
        pagination.setRecordCount((int) page.getTotalElements());
        return page.getContent();
    }

    public Page<Customers> findAll(Pageable pageable);
    public Page<Customers> findById(int id);
    public Page<Customers> findByJobTitleContaining(String name,Pageable pageable);
    public Page<Customers> findByLastNameOrFirstName(String name1,String name2,Pageable pageable);
    public Page<Customers> findByCityStartingWith(String name,Pageable pageable);



}