package com.example.test2.Controllers;

import com.example.test2.Entities.*;
import com.example.test2.Services.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@ComponentScan
public class CourseController {
    ICourseService CourseService;

    @PostMapping("/dashboard/clubs/addClub/{idUtilisateur}/{nomUni}")
    Course addClub(@RequestBody Course club, @PathVariable String nomUni,@PathVariable Long idUtilisateur){

        return CourseService.addClub(club,nomUni,idUtilisateur);
    }

    @GetMapping("/dashboard/clubs/getOneClub/{id}")
    Course getClub(@PathVariable Long id){
        return CourseService.getClub(id);
    }


    @GetMapping("/dashboard/clubs/getOneUser/{id}")
    User getUser(@PathVariable Long id){
        return CourseService.getUser(id);
    }

    @GetMapping("/dashboard/universite")
    public List<Specialite> getAllUniversities() {
        return CourseService.getAllUniversites();
    }

    @GetMapping("/dashboard/clubs")
    List<Course> getAllClubs(){
        return CourseService.getAllClubs();
    }

    @DeleteMapping("/dashboard/clubs/deleteClub/{id}")
    void deleteClubById(@PathVariable Long id){
        this.CourseService.deleteClubById(id);
    }

    @PutMapping("/dashboard/clubs/updateClub/{nomUni}")
    Course updateClub(@RequestBody Course club, @PathVariable String nomUni){
        return  this.CourseService.updateClub(club, nomUni);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    @PostMapping("/dashboard/clubs/uploadImage/{id}")
    public Course handleImageFileUpload(@RequestParam("fileImage") MultipartFile fileImage, @PathVariable long id) {
        return CourseService.handleImageFileUpload(fileImage,id);
    }
   

    @PostMapping("/shareFb/{id}")
    public String shareFb(@PathVariable Long id){
        return CourseService.shareFb(id);
    }


    @GetMapping("/azz/{query}")
    public ResponseEntity<String> getDefinition(@PathVariable String query) {
        String definition = CourseService.getDefinition(query);

        // Set the Content-Type header to plain text
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        return new ResponseEntity<>(definition, headers, HttpStatus.OK);
    }

    @GetMapping("/getImageUrl")
    public String getImageUrl(@RequestBody String query) {
        String imageLink = CourseService.getImageUrl(query);
        return "Image Link: " + imageLink;


    }

    /*@GetMapping("/getImageLink")
    public String getImageLink(@RequestBody String query) {
        String imageLink = CourseService.getImageLink(query);
        return "Image Link: " + imageLink;


    }*/

    @PostMapping("/create-meet")
    public String createMeet(@RequestBody String meetingName) {

        String meetLink = "https://meet.jit.si/" + meetingName;
        return meetLink;
    }

    @PostMapping("/affecterCoursAUtilisateur")
    public void affecterCoursAUtilisateur() {
        Long idCourse = 18L;
        Long idUtilisateur = 3L;// Définir la valeur de idCourse
        CourseService.affecterCoursAUtilisateur(idCourse, idUtilisateur);
    }

    private static final String API_KEY = "AIzaSyBLlgg2pLtecrC5J8pUoNEic2IqwZrGWUQ"; // Remplacez par votre clé d'API YouTube


    @GetMapping("/searchVideo")
    public String searchVideo(@RequestParam String query) {
        String apiUrl = "https://www.googleapis.com/youtube/v3/search"
                + "?part=id&type=video&maxResults=1"
                + "&q=" + query
                + "&key=" + "";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);

        // Extraire l'ID de la première vidéo à partir de la réponse JSON
        String videoId = CourseService.extractVideoId(response);

        if (videoId != null) {
            return videoId;
        } else {
            return "Aucune vidéo trouvée pour '" + query + "'.";
        }
    }

    @PostMapping("/saveRating/{idClub}")
    public Rating saveRating(@RequestBody Rating rating, @PathVariable  Long idClub) {
        return CourseService.saveRating(rating,idClub);
    }

    @GetMapping("/clubs/averageRating/{idClub}")
    public ResponseEntity<Double> getAverageRatingForClub(@PathVariable Long idClub) {
        try {

            Double averageRating = CourseService.calculateAverageRating(idClub);
            return ResponseEntity.ok(averageRating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/dashboard/countUsersAssignedToCoursesCreatedByUser")
    public ResponseEntity<Integer> countUsersAssignedToCoursesCreatedByUser(@RequestParam(required = true) Long creatorUserId) {
        try {
            int count = CourseService.countUsersAssignedToCoursesCreatedByUser(creatorUserId);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/monthlyRevenue/{userId}")
    public ResponseEntity<List<Double>> getMonthlyRevenue(@PathVariable Long userId) {
        List<Double> monthlyRevenue = CourseService.calculateMonthlyRevenue(userId);
        return ResponseEntity.ok(monthlyRevenue);
    }
}
