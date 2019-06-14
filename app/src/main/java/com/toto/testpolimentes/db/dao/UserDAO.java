package com.toto.testpolimentes.db.dao;

import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.toto.testpolimentes.db.model.User;
import com.toto.testpolimentes.db.model.User_Table;

import java.util.List;

public class UserDAO  {

    public void delete(){

        Delete.table(User.class);

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
