package tn.esprit.backend.Services;

import tn.esprit.backend.entities.PromoCode;

import java.util.List;

public interface IPromoCodeService {

    PromoCode AddPromoCode (PromoCode pc);
    PromoCode EditPromoCode (PromoCode pc);

    void DeletePromoCode(Long idpc);


     List<PromoCode> FindAll() ;

}
