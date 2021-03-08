package com.rps.repository;
import com.rps.entities.datamodel.GameResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameResultRepo extends JpaRepository<GameResult, Integer>{
}
