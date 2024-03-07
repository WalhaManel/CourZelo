package tn.esprit.backend.Services;

import tn.esprit.backend.entities.Purshase;

public interface IPurshasSer {
    Iterable<Purshase> getPurchases(Long id);
    void confirmPurchases(Long id);

}
