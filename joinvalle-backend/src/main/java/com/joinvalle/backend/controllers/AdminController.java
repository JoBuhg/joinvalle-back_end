package com.joinvalle.backend.controllers;

import com.joinvalle.backend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // GET /admin/aprovacoes
    @GetMapping("/aprovações")
    public ResponseEntity<?> getPendingContent() {
        return ResponseEntity.ok(adminService.getPendingContent());
    }

    // PUT /admin/eventos/{id}?status=approve|reject
    @PutMapping("/eventos/{id}")
    public ResponseEntity<?> updateEventStatus(@PathVariable Long id, @RequestParam String status) {
        if (status.equalsIgnoreCase("approve")) {
            return adminService.approveEvent(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        } else if (status.equalsIgnoreCase("reject")) {
            return adminService.rejectEvent(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().body("Invalid status");
    }

    // PUT /admin/perfis/{id}?status=approve|reject
    @PutMapping("/perfis/{id}")
    public ResponseEntity<?> updateProfileStatus(@PathVariable Long id, @RequestParam String status) {
        if (status.equalsIgnoreCase("approve")) {
            return adminService.approveProfile(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        } else if (status.equalsIgnoreCase("reject")) {
            return adminService.rejectProfile(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().body("Invalid status");
    }
}
