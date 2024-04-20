package com.example.mark;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MarkService {

        private final MarkRepository markRepository;

        public void addMark(Mark mark){
            markRepository.save(mark);
        }

        public List<Mark> getMarks(){
            return markRepository.findAll();
        }

        public Mark getMarkById(Integer id){
            return markRepository.findById(id).orElse(Mark.builder().mark(MarkEnum.valueOf("NOT_FOUND")).build());
         }

        public void removeMark(Integer id){
            markRepository.deleteById(id);
        }
}
