package com.kban.nbaapp.nbascoresapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kban.nbaapp.nbascoresapp.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
