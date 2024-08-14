package innodraw.collaborativewhiteboard.whiteboard.controller;

import innodraw.collaborativewhiteboard.whiteboard.model.Drawing;
import innodraw.collaborativewhiteboard.whiteboard.model.Point;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WhiteboardController {

    @MessageMapping("/draw")
    @SendTo("/topic/drawings")
    public Drawing broadcastDrawing(Drawing drawing) {
        System.out.println("Broadcasting drawing: " + drawing);
        return drawing;
    }

    @MessageMapping("/point")
    @SendTo("/topic/points")
    public Point broadcastPoint(Point point) {
        System.out.println("Broadcasting point: " + point);
        return point;
    }
}

