package innodraw.collaborativewhiteboard.whiteboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WhiteboardViewController {

    @GetMapping("/whiteboard")
    public String showWhiteboard() {
        return "whiteboard"; // this should match the name of your template file (whiteboard.html)
    }
}
