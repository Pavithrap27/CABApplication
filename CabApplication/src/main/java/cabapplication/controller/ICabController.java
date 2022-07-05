package cabapplication.controller;

public class ICabController {
}

//	package com.cg.cab_booking_app.controller;
//
//	import java.util.List;
//	import java.util.stream.Collectors;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.stereotype.Controller;
//	import org.springframework.ui.Model;
//	import org.springframework.web.bind.annotation.DeleteMapping;
//	import org.springframework.web.bind.annotation.GetMapping;
//	import org.springframework.web.bind.annotation.ModelAttribute;
//	import org.springframework.web.bind.annotation.PathVariable;
//	import org.springframework.web.bind.annotation.PostMapping;
//	import org.springframework.web.bind.annotation.PutMapping;
//	import org.springframework.web.bind.annotation.RequestBody;
//	import org.springframework.web.bind.annotation.RequestMapping;
//	import org.springframework.web.bind.annotation.RestController;
//	import org.springframework.web.servlet.ModelAndView;
//
//	import com.cg.cab_booking_app.exception.CabNotFoundException;
//	import com.cg.cab_booking_app.model.Cab;
//	import com.cg.cab_booking_app.model.Customer;
//	import com.cg.cab_booking_app.model.Driver;
//	import com.cg.cab_booking_app.service.CabServiceImpl;
//	import com.cg.cab_booking_app.service.CustomerServiceImpl;
//
//	@Controller
//	@RequestMapping("/cab")
//	public class CabController {
//		
//		@Autowired
//		CabServiceImpl cabService;
//		@Autowired
//		CustomerServiceImpl customerService;
//		
//		@RequestMapping("/addform")
//		public String addCabPage() {
//			return "addCab";
//		}
//		
//		@RequestMapping("/edit/{cabId}")
//		public ModelAndView showEditPage(@PathVariable int cabId) {
//			 ModelAndView mv=new ModelAndView("updateCab");
//			 Cab cab=cabService.viewCab(cabId);
//			 mv.addObject("cab", cab);
//			return mv;
//		}
//		
//		@PostMapping("/add")
//		public String addCab(@ModelAttribute("cab") Cab cab) {
//			cabService.insertCab(cab);
//			return "redirect:/cab/allcab";
//		}
//		
//		@RequestMapping("/update")
//		public String updateCab(@ModelAttribute("cab") Cab cab) throws CabNotFoundException {
//			Cab c=null;
//			try {
//				c=cabService.viewCab(cab.getCabId());
//			}
//			catch(Exception e) {
//				throw new CabNotFoundException("Cab is not found for updating");
//			}
//			c=cabService.updateCab(cab);
//			return "redirect:/cab/allcab";
//		}
//		
//		@RequestMapping("/delete/{cabId}")
//		public String deleteCab(@PathVariable int cabId) throws CabNotFoundException {
//			Cab cab=null;
//			try {
//				cab=cabService.viewCab(cabId);
//			}
//			catch(Exception e){
//				throw new CabNotFoundException("Cab is not found with id "+cabId+" for deletting");
//			}
//			try {
//				cab=cabService.deleteCab(cabId);
//			}
//			catch(Exception e) {
//				throw new CabNotFoundException("can not delete: Driver using this cab");
//			}
//			return "redirect:/cab/allcab";
//		}
//		
//		@GetMapping("/view/{cabId}")
//		public Cab viewCab(@PathVariable int cabId) throws CabNotFoundException {
//			Cab cab=null;
//			try {
//				cab=cabService.viewCab(cabId);
//			}catch(Exception e) {
//				throw new CabNotFoundException("Cab is not found with id "+cabId);
//			}
//			return cab;
//		}
//		
//		@RequestMapping("viewcablist/{customerId}")
//		public String getCabList(@PathVariable("customerId") int customerId, Model model) throws CabNotFoundException{
//			
//			List<Cab> cabList=cabService.viewCabList();
//			if(cabList.isEmpty()) {
//				throw new CabNotFoundException("Cab list is empty");
//			}
//			Customer customer=customerService.viewCustomer(customerId);
//			model.addAttribute("cabs",cabList);
//			model.addAttribute("customer",customer);
//			return "availableCabs";
//		}
//		
//		@RequestMapping("/allcab")
//		public String getCabLists(Model model) throws CabNotFoundException{
//			
//			List<Cab> cabList=cabService.viewCabList();
//			if(cabList.isEmpty()) {
//				throw new CabNotFoundException("Cab list is empty");
//			}
//			model.addAttribute("cabs",cabList);
//			model.addAttribute("count",cabList.size());
//			return "manageCab";
//		}
//		
//		@GetMapping("/viewcar/{carType}")
//		public List<Cab> getCabOfType(@PathVariable String carType) throws CabNotFoundException{
//			List<Cab> cabList=null;
//			cabList=cabService.viewCabsOfType(carType);
//			if(cabList.isEmpty()) {
//				throw new CabNotFoundException("There is not cab of type "+carType);
//			}
//			return cabList;
//		}
//		
//		@GetMapping("/count/{carType}")
//		public int getCountCabOfType(@PathVariable String carType) {
//			return cabService.countCabsOfType(carType);
//		}
//	}