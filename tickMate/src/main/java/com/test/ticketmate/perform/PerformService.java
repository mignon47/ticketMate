package com.test.ticketmate.perform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerformService {

    @Autowired
    private PerformRepository performRepository;

    public void registerPerform(Perform perform) {
        performRepository.save(perform);
    }

}
