    package tn.esprit.backend.Services;


    import tn.esprit.backend.entities.Hardware;

    import java.util.List;

    public interface IHardwareService {
        public List<Hardware> retriveAllHardware();
        public Hardware retriveHardware(Long hardwareId);
        public Hardware addHardware(Hardware f);
        public void removeHardware(Long hardwareId);
        public Hardware modifyHardware(Hardware hardware);

}
