package com.abdelrahman.amin.impl;


import com.abdelrahman.amin.entity.User;
import com.abdelrahman.amin.repository.UserRepository;
import com.abdelrahman.amin.service.impl.MyUserDetailsServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class MyUserDetailsServiceImplImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private MyUserDetailsServiceImpl myUserDetailsService;

    @Test
    public void loadUserByUsername_goodCredentials_returnUser() {
        User user = new User();
        user.setEnabled(true);
        user.setPassword("a");
        user.setUsername("a");
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(user);
        myUserDetailsService.loadUserByUsername("a");
        Assert.assertEquals(user.getUsername(),"a");
    }
    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_badCredentials_returnUser() {
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(null);
        myUserDetailsService.loadUserByUsername("a");
    }
}