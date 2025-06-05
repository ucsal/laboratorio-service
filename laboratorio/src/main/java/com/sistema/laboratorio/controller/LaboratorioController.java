package com.sistema.laboratorio.controller;

import com.sistema.laboratorio.model.Laboratorio;
import com.sistema.laboratorio.service.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioService service;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Laboratorio> criar(@RequestBody Laboratorio laboratorio) {
        return ResponseEntity.ok(service.salvar(laboratorio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Laboratorio>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Laboratorio>> listarDisponiveis() {
        return ResponseEntity.ok(service.listarDisponiveis());
    }

    @PutMapping("/{id}/disponibilidade")
    public ResponseEntity<Laboratorio> atualizarDisponibilidade(@PathVariable Long id, @RequestParam boolean disponivel) {
        return ResponseEntity.ok(service.atualizarDisponibilidade(id, disponivel));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
