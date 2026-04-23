package com.example.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/feedback")
    public String displayFeedbackForm() {
        return "forward:/feedback.html";
    }

    @PostMapping("/saveFeedback")
    @ResponseBody
    public String saveFeedback(@RequestParam String name, 
                               @RequestParam String bookName, 
                               @RequestParam String feedback) {
        Feedback f = new Feedback();
        f.setName(name);
        f.setBookName(bookName);
        f.setFeedback(feedback);
        feedbackRepository.save(f);
        return "feedback saved!";
    }
}
