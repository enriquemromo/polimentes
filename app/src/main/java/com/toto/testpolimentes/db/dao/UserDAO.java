package com.toto.testpolimentes.db.dao;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.toto.testpolimentes.db.model.User;

import java.util.List;

public class UserDAO  {

    public void delete(User user){

        user.delete();

    }

    public void create(User user){

        user.save();

    }

    public User getUser(){
      List<User> users =  SQLite.select()
                .from(User.class).queryList();

      if(users.size()==1){
          return  users.get(0);
      }
      return null;

    }
}
