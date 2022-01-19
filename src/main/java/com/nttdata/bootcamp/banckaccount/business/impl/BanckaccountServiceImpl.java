package com.nttdata.bootcamp.banckaccount.business.impl;

import com.nttdata.bootcamp.banckaccount.business.BanckaccountService;
import com.nttdata.bootcamp.banckaccount.model.Banckaccount;
import com.nttdata.bootcamp.banckaccount.repository.BanckaccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BanckaccountServiceImpl implements BanckaccountService {
  @Autowired
  private BanckaccountRepository banckaccountRepository;

  @Override
  public Mono<Banckaccount> create(Banckaccount banckaccount) {
    banckaccount.setStatus(true);
    return banckaccountRepository.save(banckaccount);
  }

  @Override
  public Mono<Banckaccount> findById(String banckaccountId) {
    return banckaccountRepository.findById(banckaccountId);
  }

  @Override
  public Flux<Banckaccount> findAll() {
    return banckaccountRepository.findAll();
  }

  @Override
  public Mono<Banckaccount> update(Banckaccount banckaccount) {
    return banckaccountRepository.findById(banckaccount.getId()).map(ba -> banckaccount)
        .flatMap(this.banckaccountRepository::save);
  }
}
