package com.app.service;

import java.util.List;

import com.app.dto.AdmitDTO;
import com.app.entities.Admit;
import com.app.entities.Medicine;
import com.app.entities.Room;

public interface IRoomService {

	List<Room> getAllRoom();

}
