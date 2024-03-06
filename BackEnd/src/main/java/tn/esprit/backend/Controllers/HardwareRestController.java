package tn.esprit.backend.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.Services.IHardwareService;
import tn.esprit.backend.entities.Hardware;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Hardware")

public class HardwareRestController {
    IHardwareService hardwareService;

    @GetMapping("/retrieve-all-hardwares")
    public List<Hardware>getHardwares(){
     List<Hardware> listHardwares = hardwareService.retriveAllHardware();
        return listHardwares;
    }
    @GetMapping("/retrieve-hardware/{hardware-id}")
    public Hardware retriveHardware(@PathVariable("hardware-id") Long chId) {
        Hardware hardware = hardwareService.retriveHardware(chId);
        return hardware;
    }

    @PostMapping("/add-hardware")
    public Hardware addhardware(@RequestBody Hardware c) {
        Hardware hardware = hardwareService.addHardware(c);
        return hardware;
    }
    // http://localhost:8089/tpfoyer/hardware/remove-hardware/{hardware-id}
    @DeleteMapping("/remove-hardware/{hardware-id}")
    public void removehardware(@PathVariable("hardware-id") Long chId) {
        hardwareService.removeHardware(chId);
    }
    // http://localhost:8089/tpfoyer/hardware/modify-hardware
    @PutMapping("/modify-hardware")
    public Hardware modifyhardware(@RequestBody Hardware c) {
        Hardware hardware = hardwareService.modifyHardware(c);
        return hardware;
    }
}