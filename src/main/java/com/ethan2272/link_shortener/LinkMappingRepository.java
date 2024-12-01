package com.ethan2272.link_shortener;

import org.springframework.data.repository.Repository;
import java.util.Optional;

interface LinkMappingRepository extends Repository<LinkMapping, Long> {

    LinkMapping save(LinkMapping linkMapping);

    Optional<LinkMapping> findById(long id);
}
