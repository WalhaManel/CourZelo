package tn.esprit.backend.Services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backend.Repositories.HardwareRepository;
import tn.esprit.backend.entities.Hardware;

import java.util.List;
@Service
@AllArgsConstructor
public class HardwareServiceEmp  implements IHardwareService{
    HardwareRepository hardwareRepository;
    public List<Hardware> retrieveRepository;


    public List<Hardware> retriveAllHardware() {
        return hardwareRepository.findAll();
    }


    public Hardware retriveHardware(Long hardwareId) {
        return hardwareRepository.findById(hardwareId ).get();
    }






    public Hardware addHardware(Hardware f) {
        return hardwareRepository.save(f);
    }


    public void removeHardware(Long hardwareId) {
        hardwareRepository.deleteById(hardwareId);
    }


    public Hardware modifyHardware(Hardware hardware) {
        return hardwareRepository.save(hardware);
    }
}
