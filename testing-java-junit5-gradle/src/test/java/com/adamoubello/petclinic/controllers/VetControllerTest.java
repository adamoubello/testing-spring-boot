package com.adamoubello.petclinic.controllers;

import com.adamoubello.petclinic.ControllerTests;
import com.adamoubello.petclinic.fauxspring.Model;
import com.adamoubello.petclinic.fauxspring.ModelMapImpl;
import com.adamoubello.petclinic.model.Vet;
import com.adamoubello.petclinic.services.SpecialtyService;
import com.adamoubello.petclinic.services.VetService;
import com.adamoubello.petclinic.services.map.SpecialityMapService;
import com.adamoubello.petclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialtyService specialtyService;

    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "joe", "buck", null);
        Vet vet2 = new Vet(2L, "Jimmy", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}