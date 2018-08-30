package pl.mysior.welshblackrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mysior.welshblackrestapi.model.Comment;
import pl.mysior.welshblackrestapi.model.Cow;
import pl.mysior.welshblackrestapi.services.CommentService;
import pl.mysior.welshblackrestapi.services.CowService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/cows")
public class CommentController {


    @Autowired
    CowService cowService;
    @Autowired
    CommentService commentService;

    @PostMapping(path = "/comments")
    public ResponseEntity<Cow> addComment(@Valid @RequestBody Comment comment) throws URISyntaxException {

        Cow saved = commentService.save(comment);
        HttpHeaders header = new HttpHeaders();
        header.add("Method", "Created");
        return ResponseEntity.created(new URI("/comments" + saved.getNumber()))
                .headers(header)
                .body(saved);
    }

    @GetMapping(path = "/comments")
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @GetMapping("/{number}/comments")
    public List<Comment> getComment(@PathVariable String number) {
        Cow foundCow = cowService.findByNumber(number);
        List<Comment> comments = new ArrayList<>();
        if (foundCow != null && foundCow.getComments()!=null) {
            comments.addAll(foundCow.getComments());
        }
        return comments;
    }
}