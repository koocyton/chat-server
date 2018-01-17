package com.doopp.gauss.common.dao;

import com.doopp.gauss.common.entity.Room;
import com.doopp.gauss.common.entity.User;
import com.doopp.gauss.server.websocket.GameSocketHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Repository("roomDao")
public class RoomDao {

    // room`s session
    private static final Map<Integer, Room> rooms = new HashMap<>();

    // freeRoom`s session
    private static final Map<Integer, Room> freeRooms = new HashMap<>();

    // room id
    private static int lastRoomId = 54612;

    // 用户离开房间
    public void userLeaveRoom(int roomId, User user) {
        Room room = freeRooms.get(roomId);
    }

    // 用户加入房间
    public Room userJoinRoom(User user) {
        for (Room room : freeRooms.values()) {
            room = userJoinByRoom(room, user);
            if (room!=null) {
                return room;
            }
        }
        return userJoinSpaceRoom(user);
    }

    // 用户加入指定房间
    private Room userJoinByRoom(Room room, User user) {
        User[] users = room.getUsers();
        for (int ii=0; ii<users.length; ii++) {
            if (users[ii]==null) {
                users[ii] = user;
                return room;
            }
        }
        return null;
    }

    // 用户加入空房间
    private Room userJoinSpaceRoom(User user) {
        Room room = new Room();
        room.setId(++lastRoomId);
        User[] users = room.getUsers();
        users[0] = user;
        freeRooms.put(room.getId(), room);
        return room;
    }
}
