package com.example.mark;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/mark")
@RestController
@RequiredArgsConstructor
public class MarkController {

    private final MarkService markService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMark(@RequestBody Mark mark){
        markService.addMark(mark);
    }

    @GetMapping
    public ResponseEntity<List<Mark>> getAllMarks(){
        return ResponseEntity.ok(markService.getMarks());
    }

    @GetMapping("/{mark-id}")
    public ResponseEntity<Mark> getMarkById(@PathVariable("mark-id") Integer markId){
        return ResponseEntity.ok(markService.getMarkById(markId));

    }

}
