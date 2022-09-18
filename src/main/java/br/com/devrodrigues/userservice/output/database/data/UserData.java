package br.com.devrodrigues.userservice.output.database.data;

import br.com.devrodrigues.userservice.output.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserData extends JpaRepository<UserEntity, Integer> {
}
