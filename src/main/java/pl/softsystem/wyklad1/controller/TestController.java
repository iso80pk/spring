package pl.softsystem.wyklad1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.softsystem.wyklad1.config.AuthorizeExpressions;
import pl.softsystem.wyklad1.model.Organization;
import pl.softsystem.wyklad1.repositoty.OrganizationRepo;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private OrganizationRepo organizationRepo;

    @GetMapping("/")
    public String test() {
        return "test";
    }

    @PostMapping("/org")
    @PreAuthorize(AuthorizeExpressions.USER_OR_ADMIN)
    public Organization insertNewUser(@RequestBody Organization organization) {
        organization.getClients().forEach(client -> client.setOrganization(organization));
        return organizationRepo.saveAndFlush(organization);
    }

    @GetMapping("/org/{id}")
    public Organization getOrganizationIndex(@PathVariable Long id) {
        return organizationRepo.findById(id).orElse(null);
    }


}
