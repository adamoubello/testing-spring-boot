package springframework.samples.petclinic.service;

import com.adamoubello.model.PetType;
import com.adamoubello.repository.OwnerRepository;
import com.adamoubello.repository.PetRepository;
import com.adamoubello.repository.VetRepository;
import com.adamoubello.repository.VisitRepository;
import com.adamoubello.service.ClinicServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

    @Mock
    PetRepository petRepository;

    @Mock
    VetRepository vetRepository;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    ClinicServiceImpl service;

    @Test
    void findPetTypes() {
        //given
        List<PetType> petTypeList = new ArrayList<>();
        given(petRepository.findPetTypes()).willReturn(petTypeList);
        //when
        Collection<PetType> returnedPetTypes = service.findPetTypes();

        //then
        then(petRepository).should().findPetTypes();
        assertThat(returnedPetTypes).isNotNull();
    }
}