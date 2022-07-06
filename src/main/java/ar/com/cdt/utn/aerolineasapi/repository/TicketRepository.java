package ar.com.cdt.utn.aerolineasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.cdt.utn.aerolineasapi.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
