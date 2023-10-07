package com.crio.jukebox.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.repository.IPlaylistrepo;
import com.crio.jukebox.repository.ISongrepo;
import com.crio.jukebox.repository.IUserrepo;
import com.crio.jukebox.service.Iplaylist;
import com.crio.jukebox.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@DisplayName("UserserviceTest")
@ExtendWith(MockitoExtension.class)
public class UserserviceTest {
    @Mock
    private  IUserrepo userrepositoryMock;
    @Mock
    private IPlaylistrepo playlistrepositoryMock;
    @Mock
    private  ISongrepo songrepositoryMock;
    @InjectMocks
    private UserService userservice;


    /*
     * 
    @Test
    @DisplayName("create method should create User")
    public void create_ShouldReturnUser(){
        //Arrange
        User expectedUser = new User("1", "Yakshit", 0);
        when(userRepositoryMock.save(any(User.class))).thenReturn(expectedUser);

        //Act
        User actualUser = userService.create("Yakshit");

        //Assert
        Assertions.assertEquals(expectedUser,actualUser);
        verify(userRepositoryMock,times(1)).save(any(User.class));
    }
     */
    @Test
    @DisplayName("create method should create User")

    public void shouldreturnuser(){
        //arrange
        String name = "username";
        User user = new User(name);
        when(userrepositoryMock.save(any(User.class))).thenReturn(user);

        // Act
        User actual = userservice.create("username");
    
        // Assert
        Assertions.assertEquals(user, actual);
        verify(userrepositoryMock, times(1)).save(any(User.class));

    }

    
}
