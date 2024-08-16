package com.adamoubello.petclinic.controllers;

import com.adamoubello.petclinic.fauxspring.Model;
import com.adamoubello.petclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
