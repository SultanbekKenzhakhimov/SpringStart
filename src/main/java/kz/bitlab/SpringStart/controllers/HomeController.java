package kz.bitlab.SpringStart.controllers;

import jakarta.servlet.annotation.WebServlet;
import kz.bitlab.SpringStart.entities.Brand;
import kz.bitlab.SpringStart.entities.Item;
import kz.bitlab.SpringStart.repositories.BrandRepository;
import kz.bitlab.SpringStart.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/item")
public class HomeController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BrandRepository brandRepository;
    @GetMapping(value="/home")
    public String openHome(Model model){
        model.addAttribute("items",itemRepository.findAll());
        return "home";
    }
    @GetMapping(value="/add-item")
    public String openAddItem(){
        return "add-item";
    }
    @PostMapping(value="/add-item")
    public String addItemPost(@RequestParam(name="item-name") String name,
                              @RequestParam(name="item-price") int price,
                              @RequestParam(name="item-amount") int amount){
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setAmount(amount);
        itemRepository.save(item);
        return "redirect:home";
    }
    @GetMapping(value="/add-brand")
    public String openAddBrand(){
        return "add-brand";
    }
    @PostMapping(value="/add-brand")
    public String addBrandPost(@RequestParam(name="brand-name") String name){
        Brand brand = new Brand();
        brand.setName(name);
        brandRepository.save(brand);
        return "redirect:home";
    }
    @GetMapping(value="/details/{id}")
    public String openDetails(@PathVariable("id") Long id,
                              Model model){
        Item item = itemRepository.findAllById(id);
        model.addAttribute("item",item);
        return "details";
    }
}
