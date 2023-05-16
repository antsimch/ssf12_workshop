package sg.edu.nus.iss.ssf12_workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import sg.edu.nus.iss.ssf12_workshop.model.Image;
import sg.edu.nus.iss.ssf12_workshop.service.RandomNumberGeneratorService;

@Controller
public class RandomNumberGeneratorController {

    // injecting service class dependency
    @Autowired
    RandomNumberGeneratorService service;

    @GetMapping("/home")
    public String landingPage() {
        return "home";
    }

    @GetMapping("/get")
    public String getRandomNumber(Model model, HttpServletRequest request) {

        int number = Integer.parseInt(request.getParameter("number"));

        System.out.println("input no is: " + number);

        if ((number > 30) || (number < 1)) {
            String errorMessage = "Invalid number. Number cannot be less than 1 or more than 30";
            model.addAttribute("errorMessage", errorMessage);
            return "home";
        }

        List<Integer> randomNumbers = service.generateRandomNumbersList(number);
        List<Image> images = new ArrayList<>();

        for (int randomNumber : randomNumbers) {
            images.add(new Image(Integer.toString(randomNumber), "/images/" + Integer.toString(randomNumber) + ".png"));
        }
        System.out.println("images: " + images);

        model.addAttribute(images);

        return "display";
    }
}
