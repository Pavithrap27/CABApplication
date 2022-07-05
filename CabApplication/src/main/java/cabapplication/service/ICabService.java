package cabapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cabapplication.entity.Cab;
import cabapplication.repository.ICabRepository;

@Service
public class ICabService {

	@Autowired
	ICabRepository ICabrepo;

	public List<Cab> viewCabsOfType(String carType) 
	{
	    List<Cab> IC=ICabrepo.findAll();
	    return IC;	
	}

	public <S extends Cab> S save(S entity) {
		return ICabrepo.save(entity);
	}

	public List<Cab> findAll() {
		return ICabrepo.findAll();
	}

	public Optional<Cab> findById(Integer id) {
		return ICabrepo.findById(id);
	}

	public <S extends Cab> List<S> saveAll(Iterable<S> entities) {
		return ICabrepo.saveAll(entities);
	}

	public long count() {
		return ICabrepo.count();
	}

	public void deleteById(Integer id) {
		ICabrepo.deleteById(id);
	}

	public void deleteAll() {
		ICabrepo.deleteAll();
	}
	
	

//	public List<Cab> viewCabsOfType(String carType) {
//		return ICabrepo.viewCabsOfType(carType);
//	}
//
//	public void deleteById(Integer id) {
//		ICabrepo.deleteById(id);
//	}
//
//	public void delete(Cab entity) {
//		ICabrepo.delete(entity);
//	}
//
//	
	
	
}