package net.skhu.repository;

import net.skhu.domain.Orders;
import net.skhu.model.Option;
import net.skhu.model.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	Option[] orderBy = { new Option(0, "id 순서"), new Option(1, "id 순서 역순"), new Option(2, "이름순서") };
	Option[] searchBy = { new Option(0, "검색 없음"), new Option(1, "관리자 이름"), new Option(2, "주문자 이름") };

	Sort[] sort = { new Sort(Sort.Direction.ASC, "id"),
					new Sort(Sort.Direction.DESC, "id"),
					new Sort(Sort.Direction.ASC, "lastName") };

	public default List<Orders> findAll(Pagination pagination) {
		Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(), sort[pagination.getOb()]);

		Page<Orders> page = null;
		String searchText = pagination.getSt();
		switch (pagination.getSb()) {

			case 1:
				page = this.findByEmployeesLastName(searchText, pageable);
				break;

			case 2:
				page = this.findByCustomersLastName(searchText, pageable);
				break;

				default:
					page = this.findAll(pageable);
				break;
		}
		pagination.setRecordCount((int) page.getTotalElements());
		return page.getContent();
	}

	public Page<Orders> findAll(Pageable pageable);
	public Page<Orders> findByEmployeesLastName(String name,Pageable pageable);
	public Page<Orders> findByCustomersLastName(String name,Pageable pageable);
	public Page<Orders> findByShipName(String name, Pageable pageable);


}