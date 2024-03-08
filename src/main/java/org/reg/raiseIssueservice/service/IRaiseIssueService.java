package org.reg.raiseIssueservice.service;

import org.reg.raiseIssueservice.entity.Issue;

import java.util.List;

public interface IRaiseIssueService {
    public List<Issue> getAllIssue();
    public Issue getIssueById(Long id);
    public Issue raiseIssue(Issue issue);
    public Issue updateIssue(Issue issue);
}
