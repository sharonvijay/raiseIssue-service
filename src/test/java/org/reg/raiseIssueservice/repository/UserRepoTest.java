package org.reg.raiseIssueservice.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.reg.raiseIssueservice.entity.User;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserRepoTest {
    @Mock
    private UserRepo userRepo;

    @Test
    public void testSaveUser()
    {
        // Given
        User user = new User(1L, "raj", 2356743468L, "raj@example.com");
        when(userRepo.save(user)).thenReturn(user);

        // When
        User savedUser = userRepo.save(user);

        // Then
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("raj");
        assertThat(savedUser.getEmail()).isEqualTo("raj@example.com");
    }

    @Test
    public void testFindUserById()
    {
        // Given
        User user = new User(1L, "raj", 2356743468L, "raj@example.com");
        Long userId = user.getId();
        when(userRepo.findById(userId)).thenReturn(Optional.of(user));

        // When
        Optional<User> foundUser = userRepo.findById(userId);

        // Then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo("raj");

    }

    @Test
    public void testFindAllUsers() {
        // Given
        when(userRepo.findAll()).thenReturn(List.of(new User(1L, "raj", 2356743468L, "raj@example.com"),
                new User(2L, "shyam", 2356743469L, "shyam@example.com")));

        // When
        List<User> users = userRepo.findAll();

        // Then
        assertThat(users).hasSize(2);
    }

    @Test
    public void testUpdateUser() {
        // Given
        User user = new User(1L, "raj", 2356743468L, "raj@example.com");
        when(userRepo.save(user)).thenReturn(user);

        // When
        User updatedUser = userRepo.save(user);

        // Then
        assertThat(updatedUser.getName()).isEqualTo("raj");
    }

    @Test
    public void testDeleteUser() {
        // Given
        User user = new User(1L, "raj", 2356743468L, "raj@example.com");
        Long userId = user.getId();

        // When
        userRepo.deleteById(userId);

        // Then
        assertThat(userRepo.findById(userId)).isEmpty();
    }

}
