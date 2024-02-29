package tn.esprit.backend.Services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backend.Repositories.CousreRepository;
import tn.esprit.backend.entities.Basket;
import tn.esprit.backend.entities.Course;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {
    CousreRepository clubRepository;
//    UniversiteRepository universiteRepository;
//    FileStorageService fileStorageService;
//
//
//    @Transactional
//    @Override
//    public Course addClub(Course club, String nomUni){
//        try {
//            Universite universite =  universiteRepository.findByNomUniversite(nomUni);
//            club.setUniversite(universite);
//            return clubRepository.save(club);
//        } catch (Exception e) {
//            e.printStackTrace(); // Log or print the exception
//            throw e; // Re-throw the exception if needed
//        }
//    }
//
//    @Override
//    public List<Universite> getAllUniversites(){
//       return universiteRepository.findAll();
//    }
//
//    @Override
//    public Course getClub(Long idClub){
//        return this.clubRepository.findById(idClub).orElse(null);
//    }
//
//    @Override
//    public List<Course> getAllClubs(){
//        return  this.clubRepository.findAll();
//    }
//
//    @Override
//    public void deleteClubById(Long idCLub){
//        this.clubRepository.deleteById(idCLub);
//    }
//
//
//    @Override
//    public Course updateClub(Course club, String nomUni) {
//        Course oldClub = clubRepository.findById(club.getIdCourse()).orElse(null);
//        Universite universite = universiteRepository.findByNomUniversite(nomUni);
//        club.setUniversite(universite);
//        club.setImgUrl(oldClub.getImgUrl());
//        return clubRepository.save(club);
//    }
//
//    public Course handleImageFileUpload(MultipartFile fileImage, long id) {
//        if (fileImage.isEmpty()) {
//            return null;
//        }
//        String fileName = fileStorageService.storeFile(fileImage);
//        Course club = clubRepository.findById(id).orElse(null);
//        club.setImgUrl(fileName);
//        return clubRepository.save(club);
//    }

    public Iterable<Course> showAll()
    { return clubRepository.findAll();}
}
