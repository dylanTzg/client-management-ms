package com.classe.clientmanagementms.utils;

import com.classe.clientmanagementms.entity.ClientEntity;
import com.classe.clientmanagementms.model.Client;

import java.lang.reflect.Field;
import java.util.Map;

public class Util {

    public static void updateClientEntityFromClient(Client client, ClientEntity clientEntity) throws IllegalAccessException {
        Field[] clientFields = client.getClass().getDeclaredFields();
        Field[] clientEntityFields = clientEntity.getClass().getDeclaredFields();

        for (Field clientField : clientFields) {
            clientField.trySetAccessible();
            Object fieldValue = clientField.get(client);

            for (Field clientEntityField : clientEntityFields) {
                clientEntityField.trySetAccessible();

                if (clientField.getName().equals(clientEntityField.getName()) && fieldValue != null) {
                    clientEntityField.set(clientEntity, fieldValue);
                    break;
                }
            }
        }


    }

    public static void updateClientEntityFromClient(Map<String, Object> map, Client client) throws IllegalAccessException {
        Field[] clientEntityFields = client.getClass().getDeclaredFields();

        for (Field clientEntityField : clientEntityFields) {
            clientEntityField.trySetAccessible();
            String fieldName = clientEntityField.getName();

            if (map.containsKey(fieldName)) {
                Object fieldValue = map.get(fieldName);

                if (fieldValue != null) {
                    clientEntityField.set(client, fieldValue);
                }
            }
        }
    }
}
