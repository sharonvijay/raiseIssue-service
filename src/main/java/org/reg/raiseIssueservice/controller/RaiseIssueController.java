package org.reg.raiseIssueservice.controller;

import org.reg.raiseIssueservice.dto.IssueRequest;
import org.reg.raiseIssueservice.entity.Issue;
import org.reg.raiseIssueservice.entity.User;
import org.reg.raiseIssueservice.repository.UserRepo;
import org.reg.raiseIssueservice.service.IRaiseIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RaiseIssueController {
    @Autowired
    private IRaiseIssueService raiseIssueService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getAllIssues")
    public List<Issue> getAllIssues()
    {
        return raiseIssueService.getAllIssue();
    }
    @GetMapping("/getIssue/{id}")
    public Issue getIssueById(@PathVariable Long id)
    {
        return raiseIssueService.getIssueById(id);
    }
    @PostMapping("/createIssue")
    public ResponseEntity<Issue> createIssue(@RequestBody IssueRequest issueRequest) {
        Issue issue = new Issue();
        issue.setName(issueRequest.getName());
        issue.setRaisedAt(new Date());

        // Fetch the user entity from the database based on user id
        Optional<User> userOptional = userRepo.findById(issueRequest.getUserId());
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        User user = userOptional.get();
        issue.setRaisedBy(user);

        Issue savedIssue = raiseIssueService.raiseIssue(issue);
        return ResponseEntity.ok(savedIssue);
    }

    @PutMapping("/updateIssue")
    public Issue updateIssue(@RequestBody Issue issue)
    {
        return raiseIssueService.updateIssue(issue);
    }
}
