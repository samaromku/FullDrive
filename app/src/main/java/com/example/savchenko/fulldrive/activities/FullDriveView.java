package com.example.savchenko.fulldrive.activities;

import com.example.savchenko.fulldrive.entities.lifehacker.Item;

import java.util.List;

public interface FullDriveView {
    void setListToAdapter(List<Item> listToAdapter);
}
