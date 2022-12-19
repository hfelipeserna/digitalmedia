package digitalmedia.msusers.repository;

import digitalmedia.msusers.configuration.feign.OAuthFeignConfig;
import digitalmedia.msusers.models.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-bill", url="http://localhost:59968/bills", configuration = OAuthFeignConfig.class)
public interface IBillFeignRepository {
    @GetMapping("/{id}")
    List<Bill> getByCustomerBill(@PathVariable String id);
}
