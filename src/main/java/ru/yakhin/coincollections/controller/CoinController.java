package ru.yakhin.coincollections.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.yakhin.coincollections.DAO.CoinDAO;
import ru.yakhin.coincollections.model.Coin;

@Controller
public class CoinController {
    private final CoinDAO coinDAO;

    public CoinController(CoinDAO coinDAO) {
        this.coinDAO = coinDAO;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("coin", coinDAO.index());
        return "index";
    }
    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model){
        model.addAttribute("coin", coinDAO.showById(id));
        return "editCoin";
    }

    @GetMapping("/search")
    public String showByName(Model model) {
        model.addAttribute("coinByName", coinDAO.index());
        return "searchresult";
    }
    @GetMapping("/addcoin")
    public String addcoin(Model model){
        model.addAttribute("coin", new Coin());
        return "addcoin";
    }

    @PostMapping("/addcoin")
    public String add(@ModelAttribute("coin") Coin coin){
        coinDAO.add(coin);
        return "redirect:/addcoin";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        coinDAO.delete(id);
        return "redirect:/";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("coin") Coin coin, @PathVariable("id") int id){
        coinDAO.update(coin, id);
        return "redirect:/";
    }
}
