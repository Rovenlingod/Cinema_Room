package cinema.controllers;

import cinema.domain.CinemaRoom;
import cinema.dtos.*;
import cinema.exceptions.InvalidPurchaseException;
import cinema.exceptions.InvalidStatsPasswordException;
import cinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CinemaController {

    private CinemaService cinemaService;
    @Value("${demo.stats-password}")
    private String statsPassword;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping("/testRoom")
    public ResponseEntity<CinemaRoomCreationResponseDTO> createTestRoom() {
        return ResponseEntity.status(HttpStatus.CREATED).body(cinemaService.createTestRoom());
    }

    @GetMapping("/cinemaRooms/{id}")
    public CinemaRoom getData(@PathVariable String id) {
        return cinemaService.getCinemaRoom(id);
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDTO> purchase(@RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        return ResponseEntity.ok().body(cinemaService.purchase(purchaseRequestDTO));
    }

    @PostMapping("/return")
    public ResponseEntity<RefundResponseDTO> refund(@RequestBody RefundRequestDTO refundRequestDTO) {
        return ResponseEntity.ok().body(cinemaService.refund(refundRequestDTO));
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsDTO> refund(@RequestParam(required = false) String password) {
        if (statsPassword.equals(password)) {
            return ResponseEntity.ok().body(cinemaService.formStats());
        } else {
            throw new InvalidStatsPasswordException("The password is wrong!");
        }
    }
}
