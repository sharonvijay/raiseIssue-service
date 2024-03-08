package org.reg.raiseIssueservice.service;

import org.reg.raiseIssueservice.entity.Issue;
import org.reg.raiseIssueservice.repository.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaiseIssueImpl implements IRaiseIssueService{
    @Autowired
    private IssueRepo issueRepo;

    @Override
    public List<Issue> getAllIssue() {
        return issueRepo.findAll();
    }

    @Override
    public Issue getIssueById(Long id) {
        return issueRepo.findById(id).orElse(null);
    }

    @Override
    public Issue raiseIssue(Issue issue) {
        return issueRepo.save(issue);
    }

    @Override
    public Issue updateIssue(Issue issue) {
        Optional<Issue> existingIssueOptional = issueRepo.findById(issue.getId());
        if(existingIssueOptional.isPresent())
        {
            Issue existingIssue = existingIssueOptional.get();
            existingIssue.setStatus(issue.getStatus());

            issueRepo.save(existingIssue);
            return existingIssue;
        }
        else
        {
            return null;
        }
    }
}
