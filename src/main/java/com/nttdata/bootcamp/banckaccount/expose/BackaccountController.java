package com.nttdata.bootcamp.banckaccount.expose;

import com.nttdata.bootcamp.banckaccount.business.BanckaccountService;
import com.nttdata.bootcamp.banckaccount.model.Banckaccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class BackaccountController {

    @Autowired
    private BanckaccountService banckaccountService;

    @GetMapping("/api/banckaccounts/{id}")
    public Mono<Banckaccount> findById(@PathVariable("id") String id) {
        log.info("<--findById-->");
        return banckaccountService.findById(id);
    }

    @GetMapping("/api/banckaccounts")
    public Flux<Banckaccount> findAll() {
        log.info("<--findAll-->");
        return banckaccountService.findAll();
    }

    @PostMapping("/api/banckaccounts")
    public Mono<Banckaccount> create(@RequestBody Banckaccount banckaccount) {
        log.info("<--create-->");
        return banckaccountService.create(banckaccount);
    }

    @PutMapping("/api/banckaccounts")
    public Mono<Banckaccount> update(@RequestBody Banckaccount banckaccount) {
        log.info("<--update-->");
        return banckaccountService.update(banckaccount);
    }

    @PatchMapping("/api/banckaccounts")
    public Mono<ResponseEntity<Banckaccount>> change(@RequestBody Banckaccount banckaccount) {
        log.info("<--change-->");
        return banckaccountService.change(banckaccount).flatMap(bUpdate -> Mono.just(ResponseEntity.ok(bUpdate)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/api/banckaccounts/{id}")
    public Mono<ResponseEntity<Banckaccount>> delete(@PathVariable("id") String id) {
        log.info("<--delete-->");
        return banckaccountService.delete(id).flatMap(b -> Mono.just(ResponseEntity.ok(b)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
