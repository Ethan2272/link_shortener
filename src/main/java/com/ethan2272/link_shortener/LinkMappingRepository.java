package com.ethan2272.link_shortener;

import org.springframework.data.jpa.repository.JpaRepository;

interface LinkMappingRepository extends JpaRepository<LinkMapping, String> { }
