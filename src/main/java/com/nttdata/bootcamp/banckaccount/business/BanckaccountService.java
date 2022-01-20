package com.nttdata.bootcamp.banckaccount.business;

import com.nttdata.bootcamp.banckaccount.model.Banckaccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BanckaccountService {

  Mono<Banckaccount> create(Banckaccount banckaccount);

  Mono<Banckaccount> findById(String banckaccountId);

  Flux<Banckaccount> findAll();

  Mono<Banckaccount> update(Banckaccount banckaccount);

  Mono<Banckaccount> change(Banckaccount banckaccount);

  Mono<Banckaccount> delete(String id);
}
