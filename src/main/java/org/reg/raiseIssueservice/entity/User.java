package org.reg.raiseIssueservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private Long phoneNo;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
//    @OneToOne
//    private Issue userIssue;
//    @OneToMany(mappedBy = "raisedBy")
//    @JsonIgnoreProperties("raisedBy")
//    private List<Issue> userIssues;
}
