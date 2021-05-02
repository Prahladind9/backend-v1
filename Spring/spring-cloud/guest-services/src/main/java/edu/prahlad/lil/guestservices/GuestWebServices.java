package edu.prahlad.lil.guestservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestWebServices {
    private final GuestRepo guestRepo;

    public GuestWebServices(GuestRepo guestRepo) {
        super();
        this.guestRepo = guestRepo;
    }

    @GetMapping
    Iterable<Guest> getAllGuests() {
        return this.guestRepo.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") long id) {
        return this.guestRepo.findById(id).get();
    }
}
