package com.nttdata.bootcamp.banckaccount.repository;

import com.nttdata.bootcamp.banckaccount.model.Banckaccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanckaccountRepository extends ReactiveMongoRepository<Banckaccount, String> {

}
