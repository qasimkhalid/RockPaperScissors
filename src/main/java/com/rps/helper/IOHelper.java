package com.rps.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

final public class IOHelper {
    public static Map<String, List<String>> LoadMapFromJson() {
        try (FileReader reader = new FileReader("data/winMap.json")) {
            Type type;
            type = new TypeToken<Map>() {
            }.getType();
            return new Gson().fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
