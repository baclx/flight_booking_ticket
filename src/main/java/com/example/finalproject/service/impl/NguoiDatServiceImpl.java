package com.example.finalproject.service.impl;

import com.example.finalproject.dto.TicketOrderedDto;
import com.example.finalproject.model.NguoiDat;
import com.example.finalproject.model.User;
import com.example.finalproject.repository.NguoiDatRepository;
import com.example.finalproject.repository.UserRepository;
import com.example.finalproject.service.NguoiDatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiDatServiceImpl implements NguoiDatService {
    @Autowired
    private NguoiDatRepository nguoiDatRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<NguoiDat> findAll() {
        return null;
    }

    @Override
    public Optional<NguoiDat> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public NguoiDat save(NguoiDat nguoiDat) {
        return nguoiDatRepository.save(nguoiDat);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<TicketOrderedDto> listTicketOrderedAdmin() {
        return nguoiDatRepository.listTicketOrdered();
    }

    @Override
    public List<TicketOrderedDto> listTicketOrderedClient() {
        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByEmail(currentPrincipalName);
        return nguoiDatRepository.listTicketOrderedClient(optionalUser.get().getId());
    }
}
