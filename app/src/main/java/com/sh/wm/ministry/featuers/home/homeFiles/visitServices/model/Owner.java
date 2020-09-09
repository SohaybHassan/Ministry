package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "owners")
public class Owner {
    @PrimaryKey
    private String id ;
    private String name ;
    private String startDate ;

    public Owner(String id, String name, String startDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
    }

    public Owner() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
