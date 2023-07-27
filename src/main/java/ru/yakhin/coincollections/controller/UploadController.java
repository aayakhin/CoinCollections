package ru.yakhin.coincollections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.yakhin.coincollections.service.CoinService;
import ru.yakhin.coincollections.util.FileUploadUtil;
import ru.yakhin.coincollections.model.Coin;

import java.io.IOException;
@Controller
public class UploadController {
    private final CoinService coinService;

    @Autowired
    public UploadController(CoinService coinService) {
        this.coinService = coinService;
    }
    @PatchMapping("/aversImageUpload/{id}")
    public String aversImageUpload(@ModelAttribute("coin") Coin coin,
                         @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        coin.setAversName(fileName);
        String uploadDir = "./src/main/upload/images/"+coin.getId();
        FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
        coinService.update(coin);
        return "redirect:/edit/{id}";
    }
    @PostMapping("/reversImageUpload/{id}")
    public String reversImageUpload(@ModelAttribute("coin") Coin coin,
                         @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        coin.setReversName(fileName);
        String uploadDir = "./src/main/upload/images/"+coin.getId();
        FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
        coinService.update(coin);
        return "redirect:/edit/{id}";
    }
}
