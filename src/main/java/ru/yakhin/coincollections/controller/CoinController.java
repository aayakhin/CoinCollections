package ru.yakhin.coincollections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yakhin.coincollections.Service.CoinService;
import ru.yakhin.coincollections.Service.CountryService;
import ru.yakhin.coincollections.model.Coin;
import ru.yakhin.coincollections.model.Country;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CoinController {
    private final CoinService coinService;
    private final CountryService countryService;

    @Autowired
    public CoinController(CoinService coinService, CountryService countryService) {
        this.coinService = coinService;
        this.countryService = countryService;
    }

    @GetMapping("/")
    public String index(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            @RequestParam(required = false) String keyword) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Pageable paging = PageRequest.of(currentPage-1, pageSize);
        Page<Coin> coinPage ;

        if (keyword==null){
            coinPage = coinService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        } else {
            coinPage = coinService.search(keyword, paging);
        }
        model.addAttribute("coinPaginated", coinPage);

        int totalPages = coinPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("keyword", keyword);
        List<Country> country= countryService.countryAll();
        model.addAttribute("countryAll", country);
        model.addAttribute("coin", new Coin());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showById(@PathVariable("id") int id, Model model){
        model.addAttribute("coin", coinService.findOne(id));
        List<Country> country= countryService.countryAll();
        model.addAttribute("countryAll", country);
        return "editCoin";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("coin") Coin coin, @PathVariable("id") int id){
        coinService.update(coin, id);
        return "redirect:/edit/{id}";
    }
    @PostMapping("/addcoin")
    public String add(Coin coin){
         coinService.save(coin);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        coinService.delete(id);
        return "redirect:/";
    }
}
