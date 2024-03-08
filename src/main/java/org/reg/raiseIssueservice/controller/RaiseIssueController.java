package org.reg.raiseIssueservice.controller;

import org.reg.raiseIssueservice.entity.Issue;
import org.reg.raiseIssueservice.service.IRaiseIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaiseIssueController {
    @Autowired
    private IRaiseIssueService raiseIssueService;

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
    public Issue createIssue(@RequestBody Issue issue)
    {
        return raiseIssueService.raiseIssue(issue);
    }

    @PutMapping("/updateIssue")
    public Issue updateIssue(@RequestBody Issue issue)
    {
        return raiseIssueService.updateIssue(issue);
    }
}
