package com.example.fridayweeklychallenge6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String listCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "list";
    }



    @RequestMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "listcategories";
    }

    @GetMapping("/add")
    public String carForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "carform";
        }
        carRepository.save(car);
        return "redirect:/";
    }
    @GetMapping("/addCategory")
    public String categoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/processCategory")
    public String processCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categoryform";
        }
        categoryRepository.save(category);
        return "redirect:/";
    }


    @RequestMapping("/updateCategory/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("category", categoryRepository.findById(id));
        return "categoryform";
    }

    @RequestMapping("/deleteCategory/{id}")
    public String delCategory(@PathVariable("id") long id) {
        categoryRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/detailCategory/{id}")
    public String showCategory(@PathVariable("id") long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "showcategory";
    }

    @RequestMapping("/updateCar/{id}")
    public String updateCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("car", carRepository.findById(id));
        return "carform";
    }

    @RequestMapping("/deleteCar/{id}")
    public String delCar(@PathVariable("id") long id) {
        carRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/detailCar/{id}")
    public String showCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }


}
