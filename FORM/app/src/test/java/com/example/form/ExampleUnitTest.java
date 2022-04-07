package com.example.form;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.form.entity.Account;
import com.example.form.entity.Song;
import com.example.form.service.AccountService;
import com.example.form.util.RetrofitGenerator;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws IOException {
        Account account = new Account();
        account.setFirstName("huong");
        account.setLastName("huong");
        account.setBirthday("2001-12-30");
        account.setAddress("Ha Noi");
        account.setPassword("123");
        account.setEmail("huong123@gmail.com");
        account.setPhone("1233321");
        account.setGender(1);
        account.setAvatar("https://img.freepik.com/free-vector/spring-flower-collection_23-2148853687.jpg?size=626&ext=jpg");
        AccountService accountService = RetrofitGenerator.createService(AccountService.class);
        System.out.println(new Gson().toJson(account));
        Response<Account> response = accountService.register(account).execute();
        System.out.println(response.message());
        System.out.println(response.code());

    }
    @Test
    public void testListSong() throws IOException {
        AccountService accountService = RetrofitGenerator.createService(AccountService.class);
        List<Song> song = accountService.getSong().execute().body();
        for (Song s :
                song) {
            System.out.println(s.toString());
        }
    }
}