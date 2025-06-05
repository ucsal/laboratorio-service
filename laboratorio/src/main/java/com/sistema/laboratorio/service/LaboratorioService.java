package com.sistema.laboratorio.service;


import com.sistema.laboratorio.model.Laboratorio;
import com.sistema.laboratorio.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository repository;

    public Laboratorio salvar(Laboratorio laboratorio) {
        return repository.save(laboratorio);
    }

    public Optional<Laboratorio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Laboratorio> listarTodos() {
        return repository.findAll();
    }

    public List<Laboratorio> listarDisponiveis() {
        return repository.findByDisponivelTrue();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Laboratorio atualizarDisponibilidade(Long id, boolean disponivel) {
        Laboratorio lab = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laboratório não encontrado"));
        lab.setDisponivel(disponivel);
        return repository.save(lab);
    }
}
