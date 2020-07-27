package br.com.leodevel.aprendaquarkus.repositories;

import javax.enterprise.context.ApplicationScoped;

import br.com.leodevel.aprendaquarkus.models.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}