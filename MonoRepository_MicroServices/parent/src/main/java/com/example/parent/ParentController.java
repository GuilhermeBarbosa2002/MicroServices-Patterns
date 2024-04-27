package com.example.parent;

import com.example.parent.DTO.FullParentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/parents")
@RestController
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer addParent(@RequestBody Parent parent){

        return parentService.addParent(parent);
    }

    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents(){
        return ResponseEntity.ok(parentService.getParents());

    }
    @GetMapping("/{parent-id}")
    public ResponseEntity<Parent> getParentById(@PathVariable("parent-id") Integer parentId){
        return ResponseEntity.ok(parentService.getParentById(parentId));

    }

    @GetMapping("/with-students/{parent-id}")
    public ResponseEntity<FullParentResponse> getAllParents(@PathVariable("parent-id") Integer parentId){
        return ResponseEntity.ok(parentService.getParentsWithStudents(parentId));
    }
}
