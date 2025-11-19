package com.encurtadorUrl.Encurtador.REPOSITORIE;

import com.encurtadorUrl.Encurtador.ENTITY.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepositorie extends MongoRepository<UrlEntity, Long> {
}
