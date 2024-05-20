package ru.fafurin.taskservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fafurin.taskservice.domen.Profile;
import ru.fafurin.taskservice.dto.ProfileResponse;
import ru.fafurin.taskservice.mapper.ProfileMapper;
import ru.fafurin.taskservice.repository.ProfileRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public Profile save(ProfileResponse profileResponse) {
        Profile profile = ProfileMapper.getProfile(new Profile(), profileResponse);
        if (profileResponse.getStartedAt() != null) {
            profile.setStartedAt(convertStringToLocalDate(profileResponse.getStartedAt()));
        }
        if (profileResponse.getBirthday() != null) {
            profile.setBirthday(convertStringToLocalDate(profileResponse.getBirthday()));
        }
        return profileRepository.save(profile);
    }

    private LocalDate convertStringToLocalDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, dateTimeFormatter);
    }


}
