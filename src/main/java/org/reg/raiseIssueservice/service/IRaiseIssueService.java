package org.reg.raiseIssueservice.service;

import org.reg.raiseIssueservice.entity.Issue;
import org.reg.raiseIssueservice.entity.User;

import java.util.List;

public interface IRaiseIssueService {
    public List<Issue> getAllIssue();
    public Issue getIssueById(Long id);
    public Issue raiseIssue(Issue issue);
    public Issue updateIssue(Issue issue);
    public String showIssueStatus(Long id);
    public User getUserById(Long id);
}
