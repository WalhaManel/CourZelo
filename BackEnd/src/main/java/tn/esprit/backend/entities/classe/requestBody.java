package tn.esprit.backend.entities.classe;

import tn.esprit.backend.entities.Basket;

import java.util.List;

public class requestBody {
        private Basket basket;
        private List<Long> courses;


        public Basket getBasket() {
                return basket;
        }

        public void setBasket(Basket basket) {
                this.basket = basket;
        }

        public List<Long> getCourses() {
                return courses;
        }

        public void setCourses(List<Long> courses) {
                this.courses = courses;
        }
}
