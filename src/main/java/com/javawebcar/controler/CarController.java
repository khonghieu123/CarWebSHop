//package com.javawebcar.controler;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.javawebcar.model.Car;
//import com.javawebcar.model.SecurityUser;
//import com.javawebcar.repository.UserRepository;
//import com.javawebcar.service.CarService;
//
//@Controller
//public class  CarController {
//
//    private final CarService carService;
//    private final UserRepository userRepository;
//    @Autowired
//    public CarController(CarService carService, UserRepository userRepository) {
//        this.carService = carService;
//        this.userRepository = userRepository;
//    }
//
//    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//    @GetMapping("/show")
//    public String showCars(Model model, @AuthenticationPrincipal SecurityUser currentuser, @Param("filter1") String filter1, @Param("filter2") String filter2, @Param("filter3") String filter3) {
//        if(filter1==null && filter2==null && filter3==null) {
//            model.addAttribute("cars", carService.getCars());
//        }
//        else {
//            model.addAttribute("cars", carService.findAllByKeywords(filter1, filter2, filter3));
//        }
//        model.addAttribute("car",new Car());
//        model.addAttribute("currentUser", userRepository.findByUsername(currentuser.getUsername()));
//        return "mainpage";
//    }
//}