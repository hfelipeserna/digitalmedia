package digitalmedia.msusers.service;

import digitalmedia.msusers.models.Bill;
import digitalmedia.msusers.models.User;
import digitalmedia.msusers.repository.IBillFeignRepository;
import digitalmedia.msusers.repository.KeyCloakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public final KeyCloakRepository keyCloakRepository;
    public final IBillFeignRepository iBillFeignRepository;

    @Autowired
    public UserService(KeyCloakRepository keyCloakRepository, IBillFeignRepository iBillFeignRepository) {
        this.keyCloakRepository = keyCloakRepository;
        this.iBillFeignRepository = iBillFeignRepository;
    }

    private List<Bill> getBillByUserId(String id){
        return iBillFeignRepository.getByCustomerBill(id);
    }

    public User getBillsByUserId (String id) {
        List<Bill> listOfBillsByUserId = getBillByUserId(id);
        User user = keyCloakRepository.findById(id);
        user.setBills(listOfBillsByUserId);
        return user;
    }
}
