package com.example.student.Client;

import com.example.student.DTO.Parent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "parent-service", url = "${application.config.parents-url}")
public interface ParentClient {
    @GetMapping("/{parent-id}")
    Parent getParentById(@PathVariable("parent-id") Integer parentId);
}
