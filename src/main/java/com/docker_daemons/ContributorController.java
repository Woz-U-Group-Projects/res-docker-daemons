package com.docker_daemons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.Configuration;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/contributor")
    public class ContributorController {


        @Autowired
        ContributorRepository contributorRepository;


        @GetMapping()
        public List<Contributor> getFruits(){
            return ContributorRepository.findAll();
        }

        @PostMapping()
        public ResponseEntity<Contributor> addContributor(@RequestBody Contributor contributor){
            if(contributor.validModel()) {
                contributorRepository.save(contributor);
                return ResponseEntity.ok(contributor);
            }
            return ResponseEntity.badRequest().build();
        }


    }
}
