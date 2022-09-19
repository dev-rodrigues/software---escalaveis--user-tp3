package br.com.devrodrigues.userservice.output.http.client;

import br.com.devrodrigues.userservice.config.FeignRetryerConfig;
import br.com.devrodrigues.userservice.output.http.entity.StudentityEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "school-client",
        url = "${host.school}",
        configuration = FeignRetryerConfig.class
)
public interface SchoolClient {

    @PostMapping("/student")
    ResponseEntity<Void> saveStudent(@RequestBody StudentityEntity studentity);
}
