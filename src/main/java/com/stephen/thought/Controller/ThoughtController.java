package com.stephen.thought.Controller;

import com.stephen.thought.dto.ThoughtDto;
import com.stephen.thought.service.ThoughtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thoughts")
public class ThoughtController {

    private final ThoughtService thoughtService;

    public ThoughtController(ThoughtService thoughtService) {
        this.thoughtService = thoughtService;
    }
    @PostMapping
    public ResponseEntity<ThoughtDto> createThought(@RequestBody ThoughtDto thoughtDto){
        ThoughtDto savedThought = thoughtService.createThought(thoughtDto);
        return new ResponseEntity<>(savedThought, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThoughtDto> getThoughtById(@PathVariable("id") long categoryId){
        return ResponseEntity.ok(thoughtService.getThoughtById(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<ThoughtDto>> getAllThoughts(){
        return ResponseEntity.ok(thoughtService.getALlThoughts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThoughtDto> updateThought(@RequestBody ThoughtDto thoughtDto, @PathVariable("id") long categoryId) {
        return ResponseEntity.ok(thoughtService.updateThought(thoughtDto, categoryId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteThought(@PathVariable("id") long categoryId) {
        thoughtService.deleteThought(categoryId);
        return ResponseEntity.ok("Thought deleted successfully!."); // Return a success message
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllThoughts(@RequestBody List<Long> thoughtIds) {
        thoughtService.deleteSelectedThoughts(thoughtIds);
        return ResponseEntity.ok("Selected thoughts deleted successfully!");
    }


}
