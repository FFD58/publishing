package ru.fafurin.taskservice.mapper;

import ru.fafurin.taskservice.domen.Profile;
import ru.fafurin.taskservice.dto.ProfileResponse;

public class ProfileMapper {

    public static Profile getProfile(Profile profile, ProfileResponse profileResponse) {
        profile.setAddress(profileResponse.getAddress());
        profile.setPhone(profile.getPhone());
        return profile;
    }
}
