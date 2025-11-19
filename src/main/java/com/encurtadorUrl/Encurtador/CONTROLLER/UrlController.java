package com.encurtadorUrl.Encurtador.CONTROLLER;

import com.encurtadorUrl.Encurtador.DTOS.UrlDto;
import com.encurtadorUrl.Encurtador.DTOS.UrlResponse;
import com.encurtadorUrl.Encurtador.ENTITY.UrlEntity;
import com.encurtadorUrl.Encurtador.REPOSITORIE.UrlRepositorie;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UrlController {

    private UrlRepositorie urlRepositorie;

    public UrlController(UrlRepositorie urlRepositorie){
        this.urlRepositorie = urlRepositorie;
    }

    @PostMapping("/createUrl")
    public ResponseEntity<UrlResponse> reduceEndpoint(@RequestBody UrlDto dto, HttpServletRequest servletRequest){

        String id;

        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        }while (urlRepositorie.existsById(id));

        String newUrlReduce = servletRequest
                .getRequestURL().toString()
                .replace("/createUrl", "/" + id);

        urlRepositorie.save(new UrlEntity(id, dto.url(), newUrlReduce, LocalDateTime.now().plusMinutes(2)));
        return ResponseEntity.ok(new UrlResponse(newUrlReduce));

    }



}
